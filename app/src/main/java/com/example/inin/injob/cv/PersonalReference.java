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
import com.example.inin.injob.models.cv7.DatumCv7;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalReference extends DialogFragment {

    private String[] arraySpinnerReferenceType;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextEmail;
    EditText editTextPhone;



    public PersonalReference() {
        // Required empty public constructor
    }

    public static PersonalReference newInstance() {
        PersonalReference frag = new PersonalReference();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_reference, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.arraySpinnerReferenceType = new String[] { "Referencia Personal", "Referencia Profesional"};
        final Spinner spinnerTypeReference = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerReferenceType);
        spinnerTypeReference.setAdapter(adapter5);

        Button button  = (Button)view.findViewById(R.id.saveBtn);
        editTextName = view.findViewById(R.id.editTextName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPhone = view.findViewById(R.id.editTextPhone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long type = 0;
                if(spinnerTypeReference.getSelectedItemPosition()==0)
                {
                    type = 1;
                }
                else {
                    type = 2;
                }
                attemptSaveReference(editTextLastName.getText().toString(), editTextEmail.getText().toString(), editTextName.getText().toString(), editTextPhone.getText().toString(), type);
            }
        });

    }

    private void attemptSaveReference(String apellido , String correo, String nombre, String telefono, Long tipoReferencia)
    {
        Context context = getActivity();
        Boolean responseAttempt = false;
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Guardando información, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        Gson gson = new Gson();

        String url = "https://app.inin.global/api/cv/references";
        JSONObject jsonBody = new JSONObject();

        try{
//            jsonBody.put("apellido", email);
//            jsonBody.put("password", password);
          DatumCv7 dataCV7 = new DatumCv7();
          dataCV7.setApellido(apellido);
          dataCV7.setCorreo(correo);
          dataCV7.setNombre(nombre);
          dataCV7.setTelefono(telefono);
          dataCV7.setTipoReferencia(tipoReferencia);
            jsonBody = new JSONObject(gson.toJson(dataCV7));

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        progress.dismiss();
                        Snackbar.make(getView(), "Referencia guardada exitosamente!", Snackbar.LENGTH_LONG)
                                .setAction("Continua en el siguiente paso", null).show();
                        ((ReferencesList)getParentFragment()).getCV();
                        dismiss();



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress.dismiss();
                        Context context = getActivity();
                        Toast toast = Toast.makeText(context, error.networkResponse.data.toString(), Toast.LENGTH_SHORT);
                        toast.show();
                        error.printStackTrace();

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


}
