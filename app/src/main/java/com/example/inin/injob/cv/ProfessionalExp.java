package com.example.inin.injob.cv;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv3.DatumCv3;
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
public class ProfessionalExp extends DialogFragment {

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private void attemptSaveCv3(String puesto, String company, Long start, Long end, String description, String telefono, String direccion, String email, String website) {

        Context context = getActivity();
        Boolean responseAttempt = false;
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Guardando información, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        Gson gson = new Gson();

        String url = "https://app.inin.global/api/cv/professional";
        JSONObject jsonBody = new JSONObject();

        try{
//            jsonBody.put("apellido", email);
//            jsonBody.put("password", password);
            DatumCv3 datacv3 =  new DatumCv3();
            datacv3.setJob(puesto);
            datacv3.setCompany(company);
            datacv3.setStart(start);
            datacv3.setEnd(end);
            datacv3.setDescription(description);
            datacv3.setCompanyPhone(telefono);
            datacv3.setCompanyAddress(direccion);
            datacv3.setCompanyEmail(email);
            datacv3.setCompanyWebsite(website);

            jsonBody = new JSONObject(gson.toJson(datacv3));

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
                        ((ProfessionalExperienceList)getParentFragment()).getCV();


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
                params.put("Authorization","Bearer "+UserData.Instance().getToken());
                //..add other headers
                return params;
            }
        };;

        MySingleton.getInstance(context).addToRequestQueue(jsObjRequest);
    }



    public ProfessionalExp() {
        // Required empty public constructor
    }

    public static ProfessionalExp newInstance() {
        ProfessionalExp frag = new ProfessionalExp();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_professional_exp, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Agregar Experiencia Profesional");
        final EditText editTextPuesto = view.findViewById(R.id.editTextPuesto);
        final EditText editTextStart = view.findViewById(R.id.startDate);
        final EditText editTextEnd = view.findViewById(R.id.endDate);
        final EditText editTextDescription = view.findViewById(R.id.description);
        final EditText editTextCompany = view.findViewById(R.id.company);
        final EditText editTextDireccion = view.findViewById(R.id.editTextDireccion);
        final EditText editTextTelefono = view.findViewById(R.id.editTextTelefono);
        final EditText editTextMail = view.findViewById(R.id.editTextMail);
        final Button button = view.findViewById(R.id.saveInterest);










        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Long timeInMillisecondsStart = null;
                Long timeInMillisecondsEnd = null;

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


                attemptSaveCv3(editTextPuesto.getText().toString(), editTextCompany.getText().toString(), timeInMillisecondsStart, timeInMillisecondsEnd, editTextDescription.getText().toString(),
                        editTextTelefono.getText().toString(), editTextDireccion.getText().toString(),
                        editTextMail.getText().toString(), "");



            }
        });
    }
}
