package edu.northeastern.cs5200;

import static org.eclipse.persistence.config.ResultType.Map;
import static org.junit.Assert.assertEquals;

import edu.northeastern.cs5200.messagesServices.PriceYougeMessagesServiceBean;
import edu.northeastern.cs5200.pojo.ComparisonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TestsAPI {


  PriceYougeMessagesServiceBean ourAPI = new PriceYougeMessagesServiceBean();

  @Before
  public void setUp() {

  }

  @Test
  public void testSearchProduct() throws Exception {
    String productName = "IPhone";
    ComparisonResponse response = ourAPI.searchProduct(productName, null, "100", "100000");
    assertEquals(null,response );
  }

  @Test
  public void testSearchProductWithparameters() throws Exception {
    String productName = "scooter";

    HashMap<String,List<String>> filters = new HashMap<String,List<String>>();

    List<String> brands = new ArrayList<>();
    brands.add("xiaomi");

    filters.put("brand",brands);

    ComparisonResponse response = ourAPI.searchProduct(productName, filters , "1", "1000000");
    assertEquals(null,response );
  }

}
