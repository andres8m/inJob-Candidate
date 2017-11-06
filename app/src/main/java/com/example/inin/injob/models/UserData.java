package com.example.inin.injob.models;


import com.example.inin.injob.models.cv1.Data;
import com.example.inin.injob.models.cv2.Cv2UserData;
import com.example.inin.injob.models.cv3.DatumCv3;

import java.util.List;

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

//    public Cv1UserData getCv1() {
//        return cv1;
//    }

    public Cv2UserData cv2;

    public Cv2UserData getCv2() {
        return cv2;
    }

    public void setCv2(Cv2UserData cv2) {
        this.cv2 = cv2;
    }

//    public void setCv1(Cv1UserData cv1) {
//        this.cv1 = cv1;
//    }


    private List<DatumCv3> cv3;

    public List<DatumCv3> getCv3() {
        return cv3;
    }

    public void setCv3(List<DatumCv3> cv3) {
        this.cv3 = cv3;
    }

    public UserData(List<DatumCv3> cv3) {
        this.cv3 = cv3;
    }

    private com.example.inin.injob.models.cv1.Data cv1;

    public Data getCv1() {
        return cv1;
    }

    public void setCv1(Data cv1) {
        this.cv1 = cv1;
    }



    public UserData(Data cv1) {
        this.cv1 = cv1;
    }

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
