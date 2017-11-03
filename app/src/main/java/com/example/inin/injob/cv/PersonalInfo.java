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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
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
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalInfo extends Fragment {
//    Context context = this.getActivity();
//    Toast toast = Toast.makeText(context, "Exito", Toast.LENGTH_SHORT);


    private String[] arraySpinnerGenero;

    private String[] arraySpinnerNacionalidades;

    private String[] arraySpinnerLicencia;

    private String[] arraySpinnerVisa;
    private String [] arraySpinnerCountry;

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

        this.arraySpinnerNacionalidades = new String[]{"Guatemalteca", "Mexicana", "Salvadoreña", "Hondureña", "Nicaraguense", "Costaricense",
                "Estadounidense", "Canadiense", "Española","Británica","Alemana","Beliceña", "Surcoreana", "Francesa", "Colombiana","Panameña",
        "Cubana", "Brasileña","Argentina","Venezolana","Chilena","China","Taiwanesa","Japonesa","Boliviana"};

        this.arraySpinnerLicencia = new String[]{"(C) Liviana", "(B) Comercial", "(A) Profesional", "(M) Motocicleta", "(E) Maquinaria Agrícola"};

        this.arraySpinnerVisa = new String[]{"Si", "No"};

        this.arraySpinnerCountry = new String[]{"Guatemala"};





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


        Date date = new Date(UserData.Instance().getCv1().getNacimiento());
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        String dateText = df2.format(date);
        EditText editTextNac = view.findViewById(R.id.birthday);
        editTextNac.setText(dateText);

                if(UserData.Instance().getCv1().getGenero().equals("M")){
                    this.arraySpinnerGenero = new String[] { "Masculino", "Femenio"};
                }
                else
                {
                    this.arraySpinnerGenero = new String[] { "Femenio", "Masculino"};
                }

        Spinner s = (Spinner) view.findViewById(R.id.generos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerGenero);
        s.setAdapter(adapter);

        Spinner s2 = (Spinner) view.findViewById(R.id.nacionalidad);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerNacionalidades);
        s2.setAdapter(adapter2);
        s2.setSelection(UserData.Instance().getCv1().getNacionalidad() - 1);

        Spinner s3 = (Spinner) view.findViewById(R.id.licencia);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerLicencia);
        s3.setAdapter(adapter3);
//        s3.setSelection(UserData.Instance().getCv1().getNacionalidad() - 1);

        Spinner s4 = (Spinner) view.findViewById(R.id.visa);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerVisa);
        s4.setAdapter(adapter4);

        if(UserData.Instance().getCv1().getVisa())
        {s4.setSelection(0);}
        else {
            s4.setSelection(1);
        }

        Spinner s5 = (Spinner) view.findViewById(R.id.pais);
        Spinner s6 = (Spinner) view.findViewById(R.id.departamento);
        Spinner s7 = (Spinner) view.findViewById(R.id.municipio);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinnerCountry);
        s5.setAdapter(adapter5);
        s6.setAdapter(adapter5);
        s7.setAdapter(adapter5);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        Context context = getActivity();
        if(UserData.Instance().getCv1().getFoto()!=null)
        {
            Picasso.with(context).load("https://s3.amazonaws.com/rrhh-images/cv/photo/"+UserData.Instance().getCv1().getFoto()).into(imageView);
        }
        else {
            Picasso.with(context).load("https://www.shareicon.net/data/2016/09/01/822711_user_512x512.png").into(imageView);
        }


    }

}
