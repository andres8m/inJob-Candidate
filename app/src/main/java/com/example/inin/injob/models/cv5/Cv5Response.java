
package com.example.inin.injob.models.cv5;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cv5Response implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<DatumCv5> data;

    private final static long serialVersionUID = -7406746325513369283L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cv5Response() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public Cv5Response(Boolean success, String message, List<DatumCv5> data) {
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

    public List<DatumCv5> getData() {
        return data;
    }

    public void setData(List<DatumCv5> data) {
        this.data = data;
    }

}
