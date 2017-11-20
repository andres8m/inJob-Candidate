package com.example.inin.injob.models;


import com.example.inin.injob.models.cv1.DataCV1;
import com.example.inin.injob.models.cv2.Cv2UserData;
import com.example.inin.injob.models.cv3.DatumCv3;
import com.example.inin.injob.models.cv4.DatumCv4;
import com.example.inin.injob.models.cv5.DatumCv5;
import com.example.inin.injob.models.cv6.DatumCv6;
import com.example.inin.injob.models.cv7.DatumCv7;
import com.example.inin.injob.models.jobs.DatumJobs;

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

    private List<DatumJobs> jobs;

    private DataCV1 cv1;


    public Cv2UserData cv2;

    private List<DatumCv3> cv3;

    private List<DatumCv4> cv4;

    public List<DatumCv5> cv5;

    public List<DatumCv6> cv6;

    private List<DatumCv7> cv7;


    // SET Constructors, GETTERS & SETTERS

    public List<DatumCv7> getCv7() {
        return cv7;
    }

    public void setCv7(List<DatumCv7> cv7) {
        this.cv7 = cv7;
    }

    public List<DatumCv6> getCv6() {
        return cv6;
    }

    public void setCv6(List<DatumCv6> cv6) {
        this.cv6 = cv6;
    }

    public List<DatumCv5> getCv5() {
        return cv5;
    }

    public void setCv5(List<DatumCv5> cv5) {
        this.cv5 = cv5;
    }

    public List<DatumJobs> getJobs() {
        return jobs;
    }

    public void setCv4(List<DatumCv4> cv4) {
        this.cv4 = cv4;
    }

    public void setJobs(List<DatumJobs> jobs) {
        this.jobs = jobs;
    }

    public List<DatumCv4> getCv4() {
        return cv4;
    }

    public Cv2UserData getCv2() {
        return cv2;
    }

    public void setCv2(Cv2UserData cv2) {
        this.cv2 = cv2;
    }

    public List<DatumCv3> getCv3() {
        return cv3;
    }

    public void setCv3(List<DatumCv3> cv3) {
        this.cv3 = cv3;
    }

    public UserData(List<DatumCv3> cv3) {
        this.cv3 = cv3;
    }


    public DataCV1 getCv1() {
        return cv1;
    }

    public void setCv1(DataCV1 cv1) {
        this.cv1 = cv1;
    }

    public UserData(DataCV1 cv1) {
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
