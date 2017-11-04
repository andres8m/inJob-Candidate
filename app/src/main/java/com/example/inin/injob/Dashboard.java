package com.example.inin.injob;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.jobs.Jobs;
import com.example.inin.injob.models.LoginResponse;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv1.Cv1UserData;
import com.example.inin.injob.models.cv1.CvResponse;
import com.example.inin.injob.tests.Tests;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);

        TextView userName = (TextView) headerView.findViewById(R.id.textviewusername);;
        userName.setText(UserData.Instance().getFirstName() +" "+ UserData.Instance().getLastName());
        TextView userEmail = (TextView) headerView.findViewById(R.id.textemail);;
        userEmail.setText(UserData.Instance().getEmail());

        ImageView imageView = (ImageView) headerView.findViewById(R.id.imageView2);
        Context context = getApplicationContext();
        Picasso.with(context).load("https://s3.amazonaws.com/rrhh-images/user/image/"+UserData.Instance().getImage()).into(imageView);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.principal_container, new MainFragment());
        transaction.commit();

        ProgressBar loadBar = findViewById(R.id.indeterminateBar);
        loadBar.setVisibility(View.INVISIBLE);




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();



//        fragments[0] = new MainFragment();

        if (id == R.id.nav_home) {
            // Handle the camera action
            transaction.replace(R.id.principal_container, new MainFragment());
            transaction.commit();
        } else if (id == R.id.nav_cv) {
            getCV();
        } else if (id == R.id.nav_jobs) {
            transaction.replace(R.id.principal_container, new Jobs());
            transaction.commit();
        } else if (id == R.id.nav_tests) {
            transaction.replace(R.id.principal_container, new Tests());
            transaction.commit();

        } else if (id == R.id.nav_share)
        {

        } else if (id == R.id.nav_send)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class parseJson extends AsyncTask<JSONObject,Void,Void>
    {
        @Override
        protected void onPreExecute() {
//            RelativeLayout loadLayout = findViewById(R.id.loadingLayout);
//            loadLayout.setVisibility(View.VISIBLE);
            ProgressBar loadBar = findViewById(R.id.indeterminateBar);
            loadBar.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.principal_container, new StepsFragment());
            transaction.commit();
            ProgressBar loadBar = findViewById(R.id.indeterminateBar);
            loadBar.setVisibility(View.INVISIBLE);
            super.onPostExecute(aVoid);
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


//                        progress.dismiss();
            Gson gson = new Gson();
            CvResponse cvResponse = gson.fromJson(jsonObjects[0].toString(), CvResponse.class);
            Cv1UserData cv1UserData = new Cv1UserData();
            cv1UserData.setNombre(cvResponse.getData().getNombre());
            cv1UserData.setApellido(cvResponse.getData().getApellido());
            cv1UserData.setDireccion(cvResponse.getData().getDireccion());
            cv1UserData.setZona(cvResponse.getData().getZona());
            cv1UserData.setCelular(cvResponse.getData().getCelular());
            cv1UserData.setTelefono(cvResponse.getData().getTelefono());
            cv1UserData.setGenero(cvResponse.getData().getGenero());
            cv1UserData.setNacimiento(cvResponse.getData().getNacimiento());
            cv1UserData.setLicencia(cvResponse.getData().getLicencia());
            cv1UserData.setVisa(cvResponse.getData().getVisa());
            cv1UserData.setFoto(cvResponse.getData().getFoto());
            cv1UserData.setPoliciacos(cvResponse.getData().getPoliciacos());
            cv1UserData.setPenales(cvResponse.getData().getPenales());
            cv1UserData.setDocumento(cvResponse.getData().getDocumento());
            cv1UserData.setUsuario(cvResponse.getData().getUsuario());
            cv1UserData.setIdentificacion(cvResponse.getData().getIdentificacion());
            cv1UserData.setPais(cvResponse.getData().getPais());
            cv1UserData.setDepartamento(cvResponse.getData().getDepartamento());
            cv1UserData.setMunicipio(cvResponse.getData().getMunicipio());
            cv1UserData.setNacionalidad(cvResponse.getData().getNacionalidad());
            UserData.Instance().setCv1(cv1UserData);

            return null;
        }
    }

    private void getCV() {
        String url = "https://app.inin.global/api/cv";

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
                params.put("Authorization","Bearer "+UserData.Instance().getToken());
                //..add other headers
                return params;
            }
        };

        MySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(jsObjRequest);



    }




}
