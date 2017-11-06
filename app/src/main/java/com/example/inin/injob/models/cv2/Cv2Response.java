
package com.example.inin.injob.models.cv2;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cv2Response implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DatumCv2> data = null;
    private final static long serialVersionUID = 3461048155189812212L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cv2Response() {
    }

    /**
     * 
     * @param message
     * @param data
     * @param success
     */
    public Cv2Response(Boolean success, String message, List<DatumCv2> data) {
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

    public List<DatumCv2> getData() {
        return data;
    }

    public void setData(List<DatumCv2> data) {
        this.data = data;
    }

}
