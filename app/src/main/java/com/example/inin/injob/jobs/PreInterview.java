package com.example.inin.injob.jobs;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.inin.injob.ApiService;
import com.example.inin.injob.R;
import com.example.inin.injob.data.remote.RetrofitClient;
import com.example.inin.injob.jobs.adapters.PreInterViewAdapter;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewMainResponse;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewQuestion;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewRequest;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreInterview extends Fragment {

    TextView textViewTitle;
    TextView textViewDate;
    TextView textViewDescription;
    PreInterviewViewModel preInterviewViewModel;
    RecyclerView recyclerView;
    PreInterViewAdapter recyclerViewAdapter;
    Button saveButton;

    public void savePreIV()
    {
        List<PreInterviewQuestion> allItems = recyclerViewAdapter.getAllItems();
//        Toast.makeText(getContext(),preInterviewQuestion.getAnswer(),Toast.LENGTH_LONG).show();
        List<PreInterviewRequest> request = new ArrayList<>();
        for(PreInterviewQuestion x: allItems)
        {
            PreInterviewRequest preInterviewRequest = new PreInterviewRequest();
            preInterviewRequest.setQuestion(x.getId());
            preInterviewRequest.setText(x.getAnswer());
            request.add(preInterviewRequest);
        }


        ApiService client = RetrofitClient.getClient("https://app.inin.global/api/").create(ApiService.class);
        Call<ResponseBody> call = client.postPreInterview(request,"Bearer "+UserData.Instance().getToken());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                Toast toast = Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG);
//                toast.show();

                if(response.code()==200)
                {
                    Snackbar.make(getView(), "¡Aplicó exitosamente a la plaza!", Snackbar.LENGTH_LONG)
                            .setAction("", null).show();


                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.principal_container, new Jobs());
                    transaction.commit();

                }
                else
                {
                    Snackbar.make(getView(), "¡Hubo un error, por favor contacté a soporte tecnico!", Snackbar.LENGTH_LONG)
                            .setAction("", null).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {


                Snackbar.make(getView(), "Lo sentimos, ¡por favor intente en un momento de nuevo!", Snackbar.LENGTH_LONG)
                        .setAction("", null).show();

//                Toast toast = Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG);
//                toast.show();

            }
        });


    }


    public PreInterview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_pre_interview, container, false);
        preInterviewViewModel = ViewModelProviders.of(getActivity()).get(PreInterviewViewModel.class);
        textViewTitle = root.findViewById(R.id.offer_name);
        textViewDate = root.findViewById(R.id.offer_date);
        textViewDescription = root.findViewById(R.id.offer_detail);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewQuestions);
        recyclerViewAdapter = new PreInterViewAdapter(this.getContext(),new ArrayList<PreInterviewQuestion>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);
        saveButton = root.findViewById(R.id.buttonSave);
        // If the start date is not defined, it's a new ViewModel so set it.
        if(preInterviewViewModel.getPreInterview()!=null)
        {
            textViewTitle.setText(preInterviewViewModel.getPreInterview().getTitle());
            textViewDescription.setText(preInterviewViewModel.getPreInterview().getDescription());

            if(preInterviewViewModel.getPreInterview().getSubmitDate()!=null)
            {
                Date date = new Date(preInterviewViewModel.getPreInterview().getSubmitDate());
                SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
                String dateText = df2.format(date);
                textViewDate.setText(dateText);
            }
        }

        getAPIData();
        updateFrontEnd();


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePreIV();
            }
        });


        return root;
    }





    public void updateFrontEnd()
    {
        // Update the SeekBar when the ViewModel is changed.
        preInterviewViewModel.detailsPreinterview.observe(getActivity(), new Observer<PreInterviewResponse>() {
            @Override
            public void onChanged(@Nullable PreInterviewResponse value) {
                if (value != null) {
//                    Toast.makeText(getContext(),value.getPosition()+" "+value.getLimitDate(),Toast.LENGTH_LONG).show();

                    if(value.getSubmitDate()!=null && value.getLimitDate()!=null)
                    {
                        Date date = new Date(value.getSubmitDate());
                        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
                        String dateText = df2.format(date);


                        Date dateLimit = new Date(value.getLimitDate());
                        SimpleDateFormat df3 = new SimpleDateFormat("dd/MM/yy");
                        String dateTextLimit = df3.format(date);
                        textViewDate.setText(dateText +" - " + dateTextLimit);
                    }

                    if(value.isAnswered())
                    {
                        saveButton.setEnabled(false);
                        saveButton.getBackground().setAlpha(100);


                        FragmentManager manager = getFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.principal_container, new Jobs());
                        saveButton.getBackground().setAlpha(255);
                        transaction.commit();


                    }




                    if(value.getQuestions()!=null)
                    {
                        recyclerViewAdapter.addItems(value.getQuestions());
                    }
                }
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getAPIData() {


        ApiService client = RetrofitClient.getClient("https://app.inin.global/api/").create(ApiService.class);
        Call<PreInterviewMainResponse> call = client.getSpecificPreInterview(preInterviewViewModel.getPreInterview().getIdPreinterview(),"Bearer "+UserData.Instance().getToken());

        call.enqueue(new Callback<PreInterviewMainResponse>() {
            @Override
            public void onResponse(Call<PreInterviewMainResponse> call, retrofit2.Response<PreInterviewMainResponse> response) {
//                Toast toast = Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG);
//                toast.show();

                if(response.code()==200)
                {
//                    Snackbar.make(getView(), "¡Imagen guardada exitosamente!", Snackbar.LENGTH_LONG)
//                            .setAction("", null).show();

                        preInterviewViewModel.detailsPreinterview.setValue(response.body().getData());


                }
                else if(response.code()==413)
                {
                    Snackbar.make(getView(), "¡Imagen demasiado grande, por favor selecciona una imagen más pequeña!", Snackbar.LENGTH_LONG)
                            .setAction("", null).show();
                }

            }

            @Override
            public void onFailure(Call<PreInterviewMainResponse> call, Throwable t) {


                Snackbar.make(getView(), "Lo sentimos, ¡por favor intente en un momento de nuevo!", Snackbar.LENGTH_LONG)
                        .setAction("", null).show();

//                Toast toast = Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG);
//                toast.show();

            }
        });

    }


}
