
package edu.northeastern.cs5200.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "price",
    "brand"
})
public class Filter implements Serializable
{

    @JsonProperty("price")
    private Price price;
    @JsonProperty("brand")
    private List<Brand> brand = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9128318273475185587L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Filter() {
    }

    /**
     * 
     * @param price
     * @param brand
     */
    public Filter(Price price, List<Brand> brand) {
        super();
        this.price = price;
        this.brand = brand;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("brand")
    public List<Brand> getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
