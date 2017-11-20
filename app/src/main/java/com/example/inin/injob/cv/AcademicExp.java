package com.example.inin.injob.cv;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inin.injob.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicExp extends DialogFragment {

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public static AcademicExp newInstance() {
        AcademicExp frag = new AcademicExp();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    public AcademicExp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_academic_exp, container, false);
    }

}
