
package com.example.inin.injob.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parentId")
    @Expose
    private Integer parentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("parentName")
    @Expose
    private String parentName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("canGive")
    @Expose
    private Boolean canGive;
    @SerializedName("canBeGiven")
    @Expose
    private Boolean canBeGiven;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("route")
    @Expose
    private String route;
    @SerializedName("give")
    @Expose
    private String give;
    @SerializedName("digital")
    @Expose
    private Boolean digital;
    @SerializedName("paymentData")
    @Expose
    private List<PaymentDatum> paymentData = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCanGive() {
        return canGive;
    }

    public void setCanGive(Boolean canGive) {
        this.canGive = canGive;
    }

    public Boolean getCanBeGiven() {
        return canBeGiven;
    }

    public void setCanBeGiven(Boolean canBeGiven) {
        this.canBeGiven = canBeGiven;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getGive() {
        return give;
    }

    public void setGive(String give) {
        this.give = give;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public List<PaymentDatum> getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(List<PaymentDatum> paymentData) {
        this.paymentData = paymentData;
    }

}
