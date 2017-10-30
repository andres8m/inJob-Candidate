package com.example.inin.injob.models;


import com.example.inin.injob.models.cv1.Cv1UserData;

/**
 * Created by Andres Canu on 24/10/2017.
 */

public class UserData {

    private static UserData instance;


    private String token;

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer countryId;

    private String alphanumericId;

    private String image;

    private Boolean passOk;

    public Cv1UserData getCv1() {
        return cv1;
    }

    public void setCv1(Cv1UserData cv1) {
        this.cv1 = cv1;
    }

    private Cv1UserData cv1;


    private UserData() {}

    public static UserData Instance()
    {
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if (instance == null)
        {
            instance = new UserData();
        }
        return instance;
    }


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


    public Boolean getPassOk() {
        return passOk;
    }

    public void setPassOk(Boolean passOk) {
        this.passOk = passOk;
    }

}
