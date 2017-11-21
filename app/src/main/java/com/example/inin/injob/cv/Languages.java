package com.example.inin.injob.cv;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv5.DatumCv5;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Languages extends DialogFragment {

    private String [] arraySpinnerCountry;
    private Button buttonSaveLanguage;
    Spinner spinnerExtraLanguage;
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
        this.arraySpinnerCountry = new String[]{"Español", "Inglés", "Frances", "Aleman","Italiano","Portugués","Japonés","Mandarín","Coreano","Ruso","Otro"};
        buttonSaveLanguage = view.findViewById(R.id.saveBtn);

        Spinner s = (Spinner) view.findViewById(R.id.maternal);
        spinnerExtraLanguage = (Spinner) view.findViewById(R.id.extra);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerCountry);
        s.setAdapter(adapter);
        spinnerExtraLanguage.setAdapter(adapter);

        buttonSaveLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer myValue = spinnerExtraLanguage.getSelectedItemPosition()+1;
//                attemptSaveCv1(editTextLName.getText().toString(),editTextcel.getText().toString(),editTextDir.getText().toString(),editTextdpi.getText().toString(),editTextName.getText().toString(),editTexttel.getText().toString(),editTextZona.getText().toString());
                Snackbar.make(view, String.valueOf(myValue), Snackbar.LENGTH_LONG)
                        .setAction("Continua en el siguiente paso", null).show();
            }
        });

    }


    private void attemptSaveCv5(Integer auditiva , Integer lectora, Integer escrita, Integer exprOral, Integer interOral, Integer languageId)
    {
        Context context = getActivity();
        Boolean responseAttempt = false;
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Guardando información, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        Gson gson = new Gson();

        String url = "https://app.inin.global/api/cv/languages";
        JSONObject jsonBody = new JSONObject();

        try{
//            jsonBody.put("apellido", email);
//            jsonBody.put("password", password);
            DatumCv5 dataCV5 = new DatumCv5();
            dataCV5.setComprensionAuditiva(auditiva);
            dataCV5.setComprensionLectora(lectora);
            dataCV5.setExpresionEscrita(escrita);
            dataCV5.setExpresionOral(exprOral);
            dataCV5.setInteraccionOral(interOral);
            dataCV5.setId(languageId);
            jsonBody = new JSONObject(gson.toJson(dataCV5));

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        progress.dismiss();
                        Snackbar.make(getView(), "Idioma guardado exitosamente!", Snackbar.LENGTH_LONG)
                                .setAction("Continua en el siguiente paso", null).show();


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress.dismiss();
                        Context context = getActivity();
                        Toast toast = Toast.makeText(context, "Error", Toast.LENGTH_SHORT);
                        toast.show();

                        // TODO Auto-generated method stub

                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization","Bearer "+UserData.Instance().getToken());
                //..add other headers
                return params;
            }
        };;

        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }



}
