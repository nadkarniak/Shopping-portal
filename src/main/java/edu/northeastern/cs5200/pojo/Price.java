
package edu.northeastern.cs5200.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "min",
    "max"
})
public class Price implements Serializable
{

    @JsonProperty("min")
    private Integer min;
    @JsonProperty("max")
    private Integer max;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3127044470615278292L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Price() {
    }

    /**
     * 
     * @param min
     * @param max
     */
    public Price(Integer min, Integer max) {
        super();
        this.min = min;
        this.max = max;
    }

    @JsonProperty("min")
    public Integer getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Integer min) {
        this.min = min;
    }

    @JsonProperty("max")
    public Integer getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Integer max) {
        this.max = max;
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
