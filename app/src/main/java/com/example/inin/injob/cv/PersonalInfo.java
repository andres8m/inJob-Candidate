package com.example.inin.injob.cv;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.inin.injob.Dashboard;
import com.example.inin.injob.MainActivity;
import com.example.inin.injob.MySingleton;
import com.example.inin.injob.R;
import com.example.inin.injob.models.LoginResponse;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv1.Cv1UserData;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalInfo extends Fragment {
//    Context context = this.getActivity();
//    Toast toast = Toast.makeText(context, "Exito", Toast.LENGTH_SHORT);




    public PersonalInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        EditText editTextName = view.findViewById(R.id.editTextName);
        editTextName.setText(UserData.Instance().getCv1().getNombre());

        EditText editTextLName = view.findViewById(R.id.editTextLastName);
        editTextLName.setText(UserData.Instance().getCv1().getApellido());

        EditText editTextdpi = view.findViewById(R.id.editTextDPI);
        editTextdpi.setText(UserData.Instance().getCv1().getIdentificacion());

        EditText editTextcel = view.findViewById(R.id.editTextCell);
        editTextcel.setText(UserData.Instance().getCv1().getCelular());

        EditText editTexttel = view.findViewById(R.id.editTextPhone);
        editTexttel.setText(UserData.Instance().getCv1().getTelefono());

        EditText editTextDir = view.findViewById(R.id.editTextDireccion);
        editTextDir.setText(UserData.Instance().getCv1().getDireccion());

        EditText editTextZona = view.findViewById(R.id.editTextZona);
        editTextZona.setText(UserData.Instance().getCv1().getZona());


    }

}
