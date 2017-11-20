package com.example.inin.injob.cv;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.inin.injob.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Languages extends DialogFragment {

    private String [] arraySpinnerCountry;
    public Languages() {
        // Required empty public constructor
    }


    public static Languages newInstance() {
        Languages frag = new Languages();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_languages, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        getDialog().setTitle("Agregar Lenguaje");
        this.arraySpinnerCountry = new String[]{"Español", "Inglés", "Frances", "Aleman"};

        Spinner s = (Spinner) view.findViewById(R.id.maternal);
        Spinner s2 = (Spinner) view.findViewById(R.id.extra);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerCountry);
        s.setAdapter(adapter);
        s2.setAdapter(adapter);

    }

}
