
package com.example.inin.injob.models.cv1.department;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartmentResponse implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DatumDepartment> data = null;
    private final static long serialVersionUID = -6790615075629479532L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DepartmentResponse() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public DepartmentResponse(Boolean success, String message, List<DatumDepartment> data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DatumDepartment> getData() {
        return data;
    }

    public void setData(List<DatumDepartment> data) {
        this.data = data;
    }

}
