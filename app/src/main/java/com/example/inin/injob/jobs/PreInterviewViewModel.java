package com.example.inin.injob.jobs;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.example.inin.injob.models.jobs.DatumJobs;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewResponse;

/**
 * Created by Andres Canu on 2/12/2017.
 */

public class PreInterviewViewModel extends ViewModel {

    @Nullable
    private DatumJobs datumJobs;

    @Nullable
    public DatumJobs getPreInterview() {
        return datumJobs;
    }

    public void setPreInterview(final DatumJobs datumJobs) {
        this.datumJobs = datumJobs;
    }

    public MutableLiveData<PreInterviewResponse> detailsPreinterview = new MutableLiveData<>();

}
