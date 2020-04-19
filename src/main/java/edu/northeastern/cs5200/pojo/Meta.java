
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
    "items",
    "filters"
})
public class Meta implements Serializable
{

    @JsonProperty("items")
    private Integer items;
    @JsonProperty("filters")
    private List<Filter> filters = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7836373290911869584L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param filters
     * @param items
     */
    public Meta(Integer items, List<Filter> filters) {
        super();
        this.items = items;
        this.filters = filters;
    }

    @JsonProperty("items")
    public Integer getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Integer items) {
        this.items = items;
    }

    @JsonProperty("filters")
    public List<Filter> getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
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
