
package com.example.inin.injob.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("alphanumericId")
    @Expose
    private String alphanumericId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("canAdminUsers")
    @Expose
    private Boolean canAdminUsers;
    @SerializedName("canAdminCompanies")
    @Expose
    private Boolean canAdminCompanies;
    @SerializedName("seller")
    @Expose
    private Boolean seller;
    @SerializedName("adviser")
    @Expose
    private Boolean adviser;
    @SerializedName("associate")
    @Expose
    private Boolean associate;
    @SerializedName("credit")
    @Expose
    private Boolean credit;
    @SerializedName("directAdviser")
    @Expose
    private Boolean directAdviser;
    @SerializedName("validated")
    @Expose
    private Boolean validated;
    @SerializedName("balance")
    @Expose
    private Integer balance;
    @SerializedName("currency")
    @Expose
    private Integer currency;


    @SerializedName("companiesReservedBalance")
    @Expose
    private Integer companiesReservedBalance;

//    @SerializedName("services")
//    @Expose
//    private List<Service> services = null;

//    @SerializedName("companyRoles")
//    @Expose
//    private List<Object> companyRoles = null;

    @SerializedName("passOk")
    @Expose
    private Boolean passOk;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getAlphanumericId() {
        return alphanumericId;
    }

    public void setAlphanumericId(String alphanumericId) {
        this.alphanumericId = alphanumericId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getCanAdminUsers() {
        return canAdminUsers;
    }

    public void setCanAdminUsers(Boolean canAdminUsers) {
        this.canAdminUsers = canAdminUsers;
    }

    public Boolean getCanAdminCompanies() {
        return canAdminCompanies;
    }

    public void setCanAdminCompanies(Boolean canAdminCompanies) {
        this.canAdminCompanies = canAdminCompanies;
    }

    public Boolean getSeller() {
        return seller;
    }

    public void setSeller(Boolean seller) {
        this.seller = seller;
    }

    public Boolean getAdviser() {
        return adviser;
    }

    public void setAdviser(Boolean adviser) {
        this.adviser = adviser;
    }

    public Boolean getAssociate() {
        return associate;
    }

    public void setAssociate(Boolean associate) {
        this.associate = associate;
    }

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public Boolean getDirectAdviser() {
        return directAdviser;
    }

    public void setDirectAdviser(Boolean directAdviser) {
        this.directAdviser = directAdviser;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getCompaniesReservedBalance() {
        return companiesReservedBalance;
    }

    public void setCompaniesReservedBalance(Integer companiesReservedBalance) {
        this.companiesReservedBalance = companiesReservedBalance;
    }

//    public List<Service> getServices() {
//        return services;
//    }
//
//    public void setServices(List<Service> services) {
//        this.services = services;
//    }
//
//    public List<Object> getCompanyRoles() {
//        return companyRoles;
//    }
//
//    public void setCompanyRoles(List<Object> companyRoles) {
//        this.companyRoles = companyRoles;
//    }

    public Boolean getPassOk() {
        return passOk;
    }

    public void setPassOk(Boolean passOk) {
        this.passOk = passOk;
    }

}
