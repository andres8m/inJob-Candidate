package com.example.inin.injob.cv;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.data.remote.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv6.Cv6Response;
import com.example.inin.injob.models.cv6.DatumCv6;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtraInfo extends Fragment {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;

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
        editText1 = view.findViewById(R.id.pb1);
        editText2 = view.findViewById(R.id.pb2);
        editText3 = view.findViewById(R.id.pb3);
        editText4 = view.findViewById(R.id.pb4);
        editText5 = view.findViewById(R.id.pb5);
        editText6 = view.findViewById(R.id.pb6);
        editText7 = view.findViewById(R.id.pb7);
        editText8 = view.findViewById(R.id.videoEdtTxt);

        getCV();

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSaveCv4();

            }
        });
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



            if(UserData.Instance().getCv6().size()>=6)
            {
                editText1.setText(UserData.Instance().getCv6().get(0).getValor());
                editText2.setText(UserData.Instance().getCv6().get(1).getValor());
                editText3.setText(UserData.Instance().getCv6().get(2).getValor());
                editText4.setText(UserData.Instance().getCv6().get(3).getValor());
                editText5.setText(UserData.Instance().getCv6().get(4).getValor());
                editText6.setText(UserData.Instance().getCv6().get(5).getValor());
                editText7.setText(UserData.Instance().getCv6().get(6).getValor());
                editText8.setText(UserData.Instance().getCv6().get(7).getValor());

            }
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

    private void attemptSaveCv4() {

        Context context = getActivity();
        Boolean responseAttempt = false;
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Guardando información, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        Gson gson = new Gson();

        String url = "https://app.inin.global/api/cv/extra";
//        JSONObject jsonBody = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        try{
//            jsonBody.put("apellido", email);
//            jsonBody.put("password", password);

            List<DatumCv6> cv6List =  UserData.Instance().getCv6();
            cv6List.get(0).setValor(editText1.getText().toString());
            cv6List.get(1).setValor(editText2.getText().toString());
            cv6List.get(2).setValor(editText3.getText().toString());
            cv6List.get(3).setValor(editText4.getText().toString());
            cv6List.get(4).setValor(editText5.getText().toString());
            cv6List.get(5).setValor(editText6.getText().toString());
            cv6List.get(6).setValor(editText7.getText().toString());
            cv6List.get(7).setValor(editText8.getText().toString());

            jsonArray = new JSONArray(gson.toJson(cv6List));
//            Cv6Response cv6Response = new Cv6Response();
//            cv6Response.setData(cv6List);
//            jsonBody = new JSONObject(gson.toJson(cv6Response));



        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonArrayRequest jsObjRequest = new JsonArrayRequest
                (Request.Method.POST, url, jsonArray, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                    }



                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                     progress.dismiss();
                            Snackbar.make(getView(), "Guardado exitosamente", Snackbar.LENGTH_LONG)
                                    .setAction("", null).show();

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
        };;

        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }


}
