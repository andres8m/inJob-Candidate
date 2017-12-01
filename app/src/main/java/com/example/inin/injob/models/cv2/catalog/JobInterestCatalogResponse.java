
package com.example.inin.injob.models.cv2.catalog;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class JobInterestCatalogResponse implements Serializable
{

    @SerializedName("success")
    @Expose
    public Boolean success;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public List<Datum> data;
    private final static long serialVersionUID = 5666284900720864896L;

}
