package com.example.inin.injob.cv;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv6.Cv6Response;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtraInfo extends Fragment {


    public ExtraInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extra_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getCV();
    }

    private void getCV() {
        String url = "https://app.inin.global/api/cv/extra";

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

            EditText editText1 = getView().findViewById(R.id.pb1);
            EditText editText2 = getView().findViewById(R.id.pb2);
            EditText editText3 = getView().findViewById(R.id.pb3);
            EditText editText4 = getView().findViewById(R.id.pb4);
            EditText editText5 = getView().findViewById(R.id.pb5);
            EditText editText6 = getView().findViewById(R.id.pb6);
            EditText editText7 = getView().findViewById(R.id.pb7);

            editText1.setText(UserData.Instance().getCv6().get(0).getValor());
            editText2.setText(UserData.Instance().getCv6().get(1).getValor());
            editText3.setText(UserData.Instance().getCv6().get(2).getValor());
            editText4.setText(UserData.Instance().getCv6().get(3).getValor());
            editText5.setText(UserData.Instance().getCv6().get(4).getValor());
            editText6.setText(UserData.Instance().getCv6().get(5).getValor());
            editText7.setText(UserData.Instance().getCv6().get(6).getValor());

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
            Cv6Response cv6Response = gson.fromJson(jsonObjects[0].toString(), Cv6Response.class);

            UserData.Instance().setCv6(cv6Response.getData());
            return null;
        }
    }

}
