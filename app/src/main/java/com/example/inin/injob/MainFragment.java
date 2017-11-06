package com.example.inin.injob;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.inin.injob.jobs.Jobs;
import com.example.inin.injob.tests.Tests;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final FragmentManager manager = getFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();

        final CardView cardViewTests = view.findViewById(R.id.psychometric_tests);
        cardViewTests.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                transaction.replace(R.id.principal_container, new Tests());
                transaction.commit();
            }
        });

        final CardView cardViewJobs = view.findViewById(R.id.ofertas);
        cardViewJobs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                transaction.replace(R.id.principal_container, new Jobs());
                transaction.commit();
            }
        });

        final CardView cardViewCV = view.findViewById(R.id.cv_complete);
        cardViewCV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                transaction.replace(R.id.principal_container, new StepsFragment());
                transaction.commit();
            }
        });



    }
}
