package com.example.inin.injob.cv;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.data.remote.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv4.DatumCv4;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicExp extends DialogFragment {

    private String[] arraySpinnerDegree;


    @Override
    public void dismiss() {
        super.dismiss();
    }

    public static AcademicExp newInstance() {
        AcademicExp frag = new AcademicExp();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    public AcademicExp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_academic_exp, container, false);
    }

    private void attemptSaveCv4(String titulo, Long status, Long start, Long end, String institucion, Long degree) {

        Context context = getActivity();
        Boolean responseAttempt = false;
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Guardando información, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        Gson gson = new Gson();

        String url = "https://app.inin.global/api/cv/academic";
        JSONObject jsonBody = new JSONObject();

        try{
//            jsonBody.put("apellido", email);
//            jsonBody.put("password", password);
            DatumCv4 datacv4 =  new DatumCv4();
            datacv4.setTittle(titulo);
            datacv4.setStatus(status);
            datacv4.setStart(start);
            datacv4.setEnd(end);
            datacv4.setInstitution(institucion);
            datacv4.setDegree(degree);


            jsonBody = new JSONObject(gson.toJson(datacv4));

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        progress.dismiss();
                        Snackbar.make(getView(), "Experiencia guardada exitosamente", Snackbar.LENGTH_LONG)
                                .setAction("", null).show();
                        ((AcademicExperienceList)getParentFragment()).getCV();


                        dismiss();


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress.dismiss();
                        Context context = getActivity();
                        String jsonError = new String(error.networkResponse.data);
                        Toast toast = Toast.makeText(context, jsonError, Toast.LENGTH_SHORT);
                        toast.show();

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
        };;

        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        getDialog().setTitle("Agregar Experiencia Academica");
        final EditText editTextTitulo = view.findViewById(R.id.editTextTitulo);
//        final EditText editTextGrado = view.findViewById(R.id.editTextGrado);
        final EditText editTextInstitucion = view.findViewById(R.id.editText3);

        final EditText editTextEnd = view.findViewById(R.id.endDate);
        final EditText editTextStart = view.findViewById(R.id.startDate);
        final Button button = view.findViewById(R.id.saveBtn);

        this.arraySpinnerDegree = new String[]{"Doctorado","Maestría","Profesional", "Técnico Superior", "Técnico", "Preparatoria",
                "Secundaria", "Primaria", "Primaria Inconclusa"};

        final Spinner s3 = (Spinner) view.findViewById(R.id.spinnerGrado);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerDegree);
        s3.setAdapter(adapter3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Long timeInMillisecondsStart = null;
                Long timeInMillisecondsEnd = null;
                Integer degreeSelected = null;

                String givenDateString = editTextStart.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                try {
                    Date mDate = sdf.parse(givenDateString);
                    timeInMillisecondsStart= mDate.getTime();
                    System.out.println("Date in milli :: " + timeInMillisecondsStart);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String endDateStr = editTextEnd.getText().toString();
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");
                try {
                    Date mDate = sdf2.parse(endDateStr);
                    timeInMillisecondsEnd = mDate.getTime();
//                    System.out.println("Date in milli :: " + timeInMilliseconds);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                degreeSelected = s3.getSelectedItemPosition()+1;


                attemptSaveCv4(editTextTitulo.getText().toString(),new Long(3),timeInMillisecondsStart,timeInMillisecondsEnd,editTextInstitucion.getText().toString(),new Long(degreeSelected));



            }
        });
    }
}
