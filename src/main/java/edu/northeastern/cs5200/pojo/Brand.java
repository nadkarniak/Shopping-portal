
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
    "name",
    "property",
    "doc_count"
})
public class Brand implements Serializable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("property")
    private String property;
    @JsonProperty("doc_count")
    private Integer docCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4258989173002196335L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Brand() {
    }

    /**
     * 
     * @param name
     * @param property
     * @param docCount
     */
    public Brand(String name, String property, Integer docCount) {
        super();
        this.name = name;
        this.property = property;
        this.docCount = docCount;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("property")
    public String getProperty() {
        return property;
    }

    @JsonProperty("property")
    public void setProperty(String property) {
        this.property = property;
    }

    @JsonProperty("doc_count")
    public Integer getDocCount() {
        return docCount;
    }

    @JsonProperty("doc_count")
    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
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
