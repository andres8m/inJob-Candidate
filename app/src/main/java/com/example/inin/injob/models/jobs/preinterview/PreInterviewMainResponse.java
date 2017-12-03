package com.example.inin.injob.models.jobs.preinterview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by Andres Canu on 3/12/2017.
 */

@Data
public class PreInterviewMainResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private PreInterviewResponse data;

}
