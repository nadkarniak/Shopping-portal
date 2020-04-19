
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
    "product_title",
    "can_compare",
    "product_lowest_price",
    "product_link",
    "product_id",
    "product_category",
    "product_sub_category",
    "product_image"
})
public class Datum implements Serializable
{

    @JsonProperty("product_title")
    private String productTitle;
    @JsonProperty("can_compare")
    private Boolean canCompare;
    @JsonProperty("product_lowest_price")
    private Integer productLowestPrice;
    @JsonProperty("product_link")
    private String productLink;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("product_category")
    private String productCategory;
    @JsonProperty("product_sub_category")
    private String productSubCategory;
    @JsonProperty("product_image")
    private String productImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3359879051746698344L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param productTitle
     * @param canCompare
     * @param productImage
     * @param productId
     * @param productSubCategory
     * @param productLink
     * @param productLowestPrice
     * @param productCategory
     */
    public Datum(String productTitle, Boolean canCompare, Integer productLowestPrice, String productLink, String productId, String productCategory, String productSubCategory, String productImage) {
        super();
        this.productTitle = productTitle;
        this.canCompare = canCompare;
        this.productLowestPrice = productLowestPrice;
        this.productLink = productLink;
        this.productId = productId;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.productImage = productImage;
    }

    @JsonProperty("product_title")
    public String getProductTitle() {
        return productTitle;
    }

    @JsonProperty("product_title")
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @JsonProperty("can_compare")
    public Boolean getCanCompare() {
        return canCompare;
    }

    @JsonProperty("can_compare")
    public void setCanCompare(Boolean canCompare) {
        this.canCompare = canCompare;
    }

    @JsonProperty("product_lowest_price")
    public Integer getProductLowestPrice() {
        return productLowestPrice;
    }

    @JsonProperty("product_lowest_price")
    public void setProductLowestPrice(Integer productLowestPrice) {
        this.productLowestPrice = productLowestPrice;
    }

    @JsonProperty("product_link")
    public String getProductLink() {
        return productLink;
    }

    @JsonProperty("product_link")
    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    @JsonProperty("product_id")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("product_category")
    public String getProductCategory() {
        return productCategory;
    }

    @JsonProperty("product_category")
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @JsonProperty("product_sub_category")
    public String getProductSubCategory() {
        return productSubCategory;
    }

    @JsonProperty("product_sub_category")
    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    @JsonProperty("product_image")
    public String getProductImage() {
        return productImage;
    }

    @JsonProperty("product_image")
    public void setProductImage(String productImage) {
        this.productImage = productImage;
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
