package com.example.inin.injob.cv;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.data.remote.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv2.Cv2Response;
import com.example.inin.injob.models.cv2.Cv2UserData;
import com.example.inin.injob.models.cv2.DatumCv2;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobInterest extends Fragment {

    ListView listViewInterests;
    SearchView searchView;


    public JobInterest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_job_interest, container, false);

        listViewInterests = root.findViewById(R.id.interestListView);
        searchView = root.findViewById(R.id.searchTxt);
        getCV();
        return root;
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



                List<String> interests = new ArrayList<>();

                for(DatumCv2 x :  UserData.Instance().getCv2().getInterests())
                {
                    interests.add(x.getName());
                }

                List<DatumCv2> cv2s = new ArrayList<>();

                final ArrayAdapter<String> arrayAdapterInterests = new ArrayAdapter<String>(
                        context, android.R.layout.simple_list_item_1, interests);
                listViewInterests.setAdapter(arrayAdapterInterests);



                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        arrayAdapterInterests.getFilter().filter(newText);
                        return false;
                    }
                });




            super.onPostExecute(aVoid);
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
            Cv2Response cv2Response = gson.fromJson(jsonObjects[0].toString(), Cv2Response.class);

            Cv2UserData cv2UserData = new Cv2UserData();
            cv2UserData.setInterests(cv2Response.getData());
            UserData.Instance().setCv2(cv2UserData);
            return null;
        }
    }


    private void getCV() {
        String url = "https://app.inin.global/api/cv/work/interest";

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











    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

    }

}
