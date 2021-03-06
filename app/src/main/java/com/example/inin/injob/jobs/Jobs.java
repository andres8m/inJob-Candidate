package com.example.inin.injob.jobs;


import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.MainFragment;
import com.example.inin.injob.data.remote.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.jobs.adapters.JobsListAdapter;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.jobs.DatumJobs;
import com.example.inin.injob.models.jobs.JobsResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Jobs extends Fragment {

    PreInterviewViewModel preInterviewViewModel;
    RecyclerView recyclerView;
    public Jobs() {
        // Required empty public constructor
    }

//    public void onMethodCallback() {
//        Snackbar.make(getView(), "¡Imagen demasiado grande, por favor selecciona una imagen más pequeña!", Snackbar.LENGTH_LONG)
//                .setAction("", null).show();    }

    public void showM(DatumJobs datumJobs)
    {
//        Toast.makeText(getContext(),datumJobs.getTitle(),Toast.LENGTH_LONG).show();
        preInterviewViewModel.setPreInterview(datumJobs);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.principal_container, new PreInterview());
        transaction.commit();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preInterviewViewModel = ViewModelProviders.of(getActivity()).get(PreInterviewViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_jobs, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCV();
    }

    public void setDataToView()
    {

        JobsListAdapter adapter = new JobsListAdapter(this.getContext(), UserData.Instance().getJobs(), Jobs.this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    public class parseJson extends AsyncTask<JSONObject,Void,Void>
    {
        @Override
        protected void onPreExecute() {
//            RelativeLayout loadLayout = findViewById(R.id.loadingLayout);
//            loadLayout.setVisibility(View.VISIBLE);
//            ProgressBar loadBar = findViewById(R.id.indeterminateBar);
//            loadBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setDataToView();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(JSONObject... jsonObjects) {
//                        progress.dismiss();
            Gson gson = new Gson();
            JobsResponse jobsResponse = gson.fromJson(jsonObjects[0].toString(), JobsResponse.class);
            UserData.Instance().setJobs(jobsResponse.getData());
            return null;
        }
    }

    private void getCV()
    {
        String url = "https://app.inin.global/api/rrhh/offerSearch";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        new parseJson().execute(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        progress.dismiss();
//                        Context context = this.getApplicationContext();
//                        Toast toast = Toast.makeText(context, "Credenciales invalidas", Toast.LENGTH_SHORT);
//                        toast.show();
                        // TODO Auto-generated method stub

                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization","Bearer "+ UserData.Instance().getToken());
                //..add other headers
                return params;
            }
        };

        MySingleton.getInstance(this.getContext()).addToRequestQueue(jsObjRequest);
    }


}
