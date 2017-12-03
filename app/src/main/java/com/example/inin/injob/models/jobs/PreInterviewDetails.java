
package com.example.inin.injob.models.jobs;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PreInterviewDetails implements Serializable
{

    @SerializedName("interesLaboral")
    @Expose
    public Integer interesLaboral;

    @SerializedName("minAge")
    @Expose
    public Integer minAge;

    @SerializedName("maxAge")
    @Expose
    public Integer maxAge;

    @SerializedName("department")
    @Expose
    public List<Integer> department = null;

    @SerializedName("licence")
    @Expose
    public List<Object> licence = null;

    @SerializedName("gender")
    @Expose
    public String gender;

    @SerializedName("languages")
    @Expose
    public List<Integer> languages = null;

    @SerializedName("visa")
    @Expose
    public Object visa;

    @SerializedName("code")
    @Expose
    public Object code;

    @SerializedName("email")
    @Expose
    public Object email;

    @SerializedName("document")
    @Expose
    public Object document;

    @SerializedName("candidateName")
    @Expose
    public Object candidateName;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("shared")
    @Expose
    public Boolean shared;

    private final static long serialVersionUID = 3464124744021768707L;

}
