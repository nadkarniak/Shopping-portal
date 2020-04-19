package edu.northeastern.cs5200.messagesServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.fastinfoset.stax.events.StAXEventReader;
import edu.northeastern.cs5200.pojo.ComparisonResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;


public class PriceYougeMessagesServiceBean {

  private static final String API_KEY = "c6tjZkZ6oQIYbFZo7UP1SQGsV9UA1AiAJtp";
  private static final String API_URL = "https://price-api.datayuge.com/api/v1/compare";
// generic method for sending requests.
  public String sendRequest(String endpoint, String parameters) throws Exception{
    String requestUrl = API_URL + endpoint + "?api_key=" + API_KEY +
        "&" + parameters;
    URL url = new URL(requestUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
    int statusCode = connection.getResponseCode();
    if(statusCode != 200) // 200 is ok code
      throw new IllegalArgumentException("poop in sendRequest");

    BufferedReader in = new BufferedReader(
        new InputStreamReader(
            connection.getInputStream()
        )
    );
    String result = "";
    StringBuilder stringBuilder = new StringBuilder();

    while((result = in.readLine()) != null) {
      stringBuilder.append(result);
    }
    in.close();

    return stringBuilder.toString();
  }
//method that does the actuall search
  public ComparisonResponse searchProduct(String productName, Map<String, List<String>> filters,
                              String priceStart, String priceEnd) throws Exception {
    String endpoint = "/search";
    StringBuilder parameters = new StringBuilder();
    productName = productName.replace(" ", "+");
    parameters.append("product=" + productName);
    if(filters != null && !filters.isEmpty()) {
      parameters.append("&filters=");
      for(String key : filters.keySet()) {
        List<String> s = filters.get(key);
        for(String str : s) {
          parameters.append(key + "%3" + str);
          parameters.append("|");
        }
      }
    }
    if(priceStart != null && !priceStart.isEmpty()) {
      parameters.append("&price_start=" + priceStart);
    }
    if(priceEnd != null && !priceEnd.isEmpty()) {
      parameters.append("&price_end=" + priceEnd);
    }

    String response = sendRequest(endpoint, parameters.toString());
    ComparisonResponse res = new ObjectMapper().readValue(response, ComparisonResponse.class);
    return res;
  }

}
