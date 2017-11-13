
package com.example.inin.injob.models.cv1.department;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumDepartment implements Serializable
{

    @SerializedName("country")
    @Expose
    private Integer country;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
//    private final static Integer serialVersionUID = -5407693066766497481L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumDepartment() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param country
     */
    public DatumDepartment(Integer country, Integer id, String name) {
        super();
        this.country = country;
        this.id = id;
        this.name = name;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
