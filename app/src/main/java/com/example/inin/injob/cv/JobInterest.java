package com.example.inin.injob.cv;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.inin.injob.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobInterest extends Fragment {


    public JobInterest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_interest, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        List<String> interests = new ArrayList<>();
        interests.add("Java Developer");
        interests.add("JavaScript Developer");
        interests.add("Scala Developer");
        interests.add("Kotlin Developer");
        interests.add("Android Developer");
        ListView lv = (ListView) view.findViewById(R.id.interestListView);
        ListView lv2 = (ListView) view.findViewById(R.id.competenciastListView);


        ArrayAdapter<String> arrayAdapterInterests = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_list_item_1, interests);
        lv.setAdapter(arrayAdapterInterests);

        List<String> competences = new ArrayList<>();
        competences.add("Capacidad de Organizacion y planificacion");
        competences.add("Comunicacion oral y escrita");
        competences.add("Resolucion de Problemas");

        ArrayAdapter<String> arrayAdapterCompetences= new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_list_item_1, competences);
        lv2.setAdapter(arrayAdapterCompetences);


    }

}
