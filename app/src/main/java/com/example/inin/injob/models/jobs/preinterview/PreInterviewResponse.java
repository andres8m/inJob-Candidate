package com.example.inin.injob.models.jobs.preinterview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Data;

/**
 * Created by Andres Canu on 3/12/2017.
 */

@Data
public class PreInterviewResponse {

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("active")
    @Expose
    private boolean active;

    @SerializedName("reminder")
    @Expose
    private boolean reminder;

    @SerializedName("position")
    @Expose
    private String position;

    @SerializedName("answered")
    @Expose
    private boolean answered;

    @SerializedName("questions")
    @Expose
    private List<PreInterviewQuestion> questions;

    @SerializedName("limitDate")
    @Expose
    private long limitDate;

    @SerializedName("submitDate")
    @Expose
    private long submitDate;

    @SerializedName("preintId")
    @Expose
    private Long preintId;

}
