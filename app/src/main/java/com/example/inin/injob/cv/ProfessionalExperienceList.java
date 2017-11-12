package com.example.inin.injob.cv;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.cv.adapters.ExperienceListAdapter;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv3.Cv3Response;
import com.google.gson.Gson;

import android.widget.Button;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessionalExperienceList extends Fragment {


    public ProfessionalExperienceList() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_professional_experience_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCV();

        final FragmentManager manager = getFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();



//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Code here executes on main thread after user presses button
//                transaction.replace(R.id.principal_container, new ProfessionalExp());
//                transaction.commit();
//            }
//        });

    }

    public void setDataToView()
    {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        ExperienceListAdapter adapter = new ExperienceListAdapter(this.getContext(), UserData.Instance().getCv3());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new GridLayoutManager(this.getContext(),2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }


    public class parseJson extends AsyncTask<JSONObject,Void,Void>
    {
        Context context = getContext();
        @Override
        protected void onPreExecute() {

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
            Gson gson = new Gson();
            Cv3Response cv3Response = gson.fromJson(jsonObjects[0].toString(), Cv3Response.class);

            UserData.Instance().setCv3(cv3Response.getData());
            return null;
        }
    }



    private void getCV() {
        String url = "https://app.inin.global/api/cv/professional";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        new parseJson().execute(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
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
