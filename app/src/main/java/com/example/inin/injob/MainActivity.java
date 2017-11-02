package com.example.inin.injob;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.models.LoginResponse;
import com.example.inin.injob.models.UserData;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        final EditText emailTxt = (EditText)findViewById(R.id.editText);
        final EditText passlTxt = (EditText)findViewById(R.id.editText2);
        final Button fab = (Button) findViewById(R.id.button);
        fab.setEnabled(false);
        fab.getBackground().setAlpha(100);




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




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                attemptLogin(emailTxt.getText().toString(), passlTxt.getText().toString());
            }
        });
    }


    private void attemptLogin(String email, String password) {
        Context context = getApplicationContext();
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
                        Context context = getApplicationContext();
                        Gson gson = new Gson();
                        LoginResponse loginResponse = gson.fromJson(response.toString(), LoginResponse.class);
                        if(loginResponse.getSuccess())
                        {
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
                        Context context = getApplicationContext();
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
