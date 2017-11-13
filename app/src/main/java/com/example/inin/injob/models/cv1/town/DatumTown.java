
package com.example.inin.injob.models.cv1.town;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatumTown implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("department")
    @Expose
    private Long department;
    private final static long serialVersionUID = -3028284190897187143L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatumTown() {
    }

    /**
     * 
     * @param id
     * @param department
     * @param name
     */
    public DatumTown(Long id, String name, Long department) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

}
