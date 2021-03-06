package com.example.inin.injob;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.data.remote.MySingleton;
import com.example.inin.injob.data.remote.RetrofitClient;
import com.example.inin.injob.models.LoginResponse;
import com.example.inin.injob.models.RegisterModel;
import com.example.inin.injob.models.UserData;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

//    private static final String[] COUNTRIES = new String[] {
//            "Belgium", "France", "Italy", "Germany", "Spain"
//    };
    private String [] arraySpinnerCountry;
    Boolean isRegister = false;
    TextView textViewRegister;
    Spinner spinnerCountries;
    AutoCompleteTextView emailTxt;
    EditText passlTxt;
    Button fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        Context context = this;
        SharedPreferences sharedPreferences = getSharedPreferences("DatFile",context.MODE_PRIVATE);
        emailTxt = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        passlTxt = (EditText)findViewById(R.id.editText2);
        fab = (Button) findViewById(R.id.button);
        textViewRegister = findViewById(R.id.textView);
        spinnerCountries = (Spinner) findViewById(R.id.spinner2);
        fab.setEnabled(false);
        fab.getBackground().setAlpha(100);

        this.arraySpinnerCountry = new String[]{"Guatemala","El Salvador","Honduras",
                "Nicaragua","Costa Rica", "México", "Colombia", "Venezuela","Ecuador",
                "Perú","Argentina","Chile","Panamá","España"};



        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, arraySpinnerCountry);



        spinnerCountries.setAdapter(adapter5);


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
//        AutoCompleteTextView textView = (AutoCompleteTextView)
//                findViewById(R.id.autoCompleteTextView);
//        textView.setAdapter(adapter);


        emailTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!emailTxt.getText().toString().equals("") && !passlTxt.getText().toString().equals(""))
                {
                    fab.setEnabled(true);
                    fab.getBackground().setAlpha(255);
                }else {
                    fab.setEnabled(false);
                    fab.getBackground().setAlpha(100);
                }
            }
        });


        passlTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!emailTxt.getText().toString().equals("") && !passlTxt.getText().toString().equals(""))
                {
                    fab.setEnabled(true);
                    fab.getBackground().setAlpha(255);
                }else {
                    fab.setEnabled(false);
                    fab.getBackground().setAlpha(100);
                }
            }
        });


        SharedPreferences sharespr = getPreferences(context.MODE_PRIVATE);
        String v1 = sharespr.getString("User","Nothing");
        String v2 = sharespr.getString("Password","Nothing");
        if(!v1.equals("Nothing") && !v2.equals("Nothing"))
        {
            attemptLogin(v1,v2);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                if(isRegister)
                {
                    registerUser();
                }
                else {
                    attemptLogin(emailTxt.getText().toString(), passlTxt.getText().toString());

                }
            }
        });

        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

//                attemptLogin(emailTxt.getText().toString(), passlTxt.getText().toString());
                isRegister=true;
                spinnerCountries.setVisibility(View.VISIBLE);
                fab.setText("Registrarse");


            }
        });
    }


    public void registerUser()
    {
        RegisterModel registerModel = new RegisterModel();
        registerModel.setMail(emailTxt.getText().toString());
        registerModel.setPais(spinnerCountries.getSelectedItemPosition()+6);
        registerModel.setPass(passlTxt.getText().toString());

        ApiService client = RetrofitClient.getClient("https://app.inin.global/api/").create(ApiService.class);
        Call<ResponseBody> call = client.registerUser(registerModel);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                Toast toast = Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG);
//                toast.show();

                if(response.code()==200)
                {
                    Toast.makeText(MainActivity.this,"Registrado exitosamente, por favor revisa tu correo para confirmar tu cuenta", Toast.LENGTH_LONG).show();
                   spinnerCountries.setVisibility(View.GONE);
                   isRegister=false;
                    fab.setText("Iniciar Sesión");


                }
                else
                {
                    spinnerCountries.setVisibility(View.GONE);
                    isRegister=false;
                    fab.setText("Iniciar Sesión");

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {


                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
                spinnerCountries.setVisibility(View.GONE);
                isRegister=false;
                fab.setText("Iniciar Sesión");

            }
        });


    }



    private void attemptLogin(final String email, final String password) {
        Context context = MainActivity.this;
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Iniciando sesión, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();

        String url = "https://app.inin.global/api/user/login";
        JSONObject jsonBody = new JSONObject();

        try{
            jsonBody.put("email", email);
            jsonBody.put("password", password);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Context context = MainActivity.this;
                        Gson gson = new Gson();
                        LoginResponse loginResponse = gson.fromJson(response.toString(), LoginResponse.class);
                        if(loginResponse.getSuccess())
                        {
                            SharedPreferences sharespr = getPreferences(context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharespr.edit();
                            editor.putString("User", email);
                            editor.putString("Password", password);
                            editor.apply();



                            final Button fab = (Button) findViewById(R.id.button);
                            fab.setEnabled(true);
                            fab.getBackground().setAlpha(255);

                            progress.dismiss();
                            UserData.Instance().setToken(loginResponse.getData().getToken());
                            UserData.Instance().setAlphanumericId(loginResponse.getData().getAlphanumericId());
                            UserData.Instance().setCountryId(loginResponse.getData().getCountryId());
                            UserData.Instance().setEmail(loginResponse.getData().getEmail());
                            UserData.Instance().setFirstName(loginResponse.getData().getFirstName());
                            UserData.Instance().setId(loginResponse.getData().getId());
                            UserData.Instance().setLastName(loginResponse.getData().getLastName());
                            UserData.Instance().setPassOk(loginResponse.getData().getPassOk());
                            UserData.Instance().setImage(loginResponse.getData().getImage());

                            Intent intent = new Intent(MainActivity.this, Dashboard.class);
                            startActivity(intent);
                        }
                        else {
                            progress.dismiss();
                            Toast toast = Toast.makeText(context, "Inicio de sesión, no exitoso", Toast.LENGTH_SHORT);
                            toast.show();
                        }




                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress.dismiss();
                        Context context = MainActivity.this;
                        Toast toast = Toast.makeText(context, "Credenciales invalidas", Toast.LENGTH_SHORT);
                        toast.show();
                        // TODO Auto-generated method stub

                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
