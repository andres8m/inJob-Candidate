package com.example.inin.injob.models.jobs.preinterview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Created by Andres Canu on 3/12/2017.
 */

@Data
public class PreInterviewQuestion {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("type")
    @Expose
    private boolean type;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("preInterview")
    @Expose
    private Long preInterview;

}
