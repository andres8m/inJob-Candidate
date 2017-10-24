
package com.example.inin.injob.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentDatum {

    @SerializedName("periodId")
    @Expose
    private Integer periodId;
    @SerializedName("tierId")
    @Expose
    private Integer tierId;
    @SerializedName("periodName")
    @Expose
    private String periodName;
    @SerializedName("tierName")
    @Expose
    private String tierName;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("costUSD")
    @Expose
    private Double costUSD;
    @SerializedName("amount")
    @Expose
    private Object amount;
    @SerializedName("details")
    @Expose
    private Object details;
    @SerializedName("associateCommission")
    @Expose
    private Integer associateCommission;
    @SerializedName("associateCommissionUSD")
    @Expose
    private Integer associateCommissionUSD;

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Integer getTierId() {
        return tierId;
    }

    public void setTierId(Integer tierId) {
        this.tierId = tierId;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Double getCostUSD() {
        return costUSD;
    }

    public void setCostUSD(Double costUSD) {
        this.costUSD = costUSD;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Integer getAssociateCommission() {
        return associateCommission;
    }

    public void setAssociateCommission(Integer associateCommission) {
        this.associateCommission = associateCommission;
    }

    public Integer getAssociateCommissionUSD() {
        return associateCommissionUSD;
    }

    public void setAssociateCommissionUSD(Integer associateCommissionUSD) {
        this.associateCommissionUSD = associateCommissionUSD;
    }

}
