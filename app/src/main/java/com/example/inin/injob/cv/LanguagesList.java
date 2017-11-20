package com.example.inin.injob.cv;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.cv.adapters.LanguageListAdapter;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv5.Cv5Response;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguagesList extends Fragment {

    void showDialog()
    {
        FragmentManager fm = getChildFragmentManager();
        Languages editNameDialogFragment = Languages.newInstance();
        editNameDialogFragment.show(fm, "fragment_add_language");
    }

    public LanguagesList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_languages_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCV();

        Button addBtn = (Button) getView().findViewById(R.id.addLanguage);
        addBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                showDialog();

            }
        });


    }

    public void setDataToView()
    {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        LanguageListAdapter adapter = new LanguageListAdapter(this.getContext(), UserData.Instance().getCv5());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new GridLayoutManager(this.getContext(),2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void getCV() {
        String url = "https://app.inin.global/api/cv/languages";

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
            Cv5Response cv5Response = gson.fromJson(jsonObjects[0].toString(), Cv5Response.class);

            UserData.Instance().setCv5(cv5Response.getData());
            return null;
        }
    }

}
