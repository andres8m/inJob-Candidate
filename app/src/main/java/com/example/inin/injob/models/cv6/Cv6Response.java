
package com.example.inin.injob.models.cv6;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cv6Response implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DatumCv6> data;
    private final static long serialVersionUID = -5816672608157069937L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cv6Response() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public Cv6Response(Boolean success, String message, List<DatumCv6> data) {
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

    public List<DatumCv6> getData() {
        return data;
    }

    public void setData(List<DatumCv6> data) {
        this.data = data;
    }

}
