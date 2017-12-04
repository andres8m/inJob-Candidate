package com.example.inin.injob.cv;


import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.inin.injob.ApiService;
import com.example.inin.injob.data.remote.MySingleton;
import com.example.inin.injob.PathUtil;
import com.example.inin.injob.R;
import com.example.inin.injob.data.remote.RetrofitClient;
import com.example.inin.injob.models.UserData;
import com.example.inin.injob.models.cv1.CvResponse;
import com.example.inin.injob.models.cv1.DataCV1;
import com.example.inin.injob.models.cv1.department.DatumDepartment;
import com.example.inin.injob.models.cv1.department.DepartmentResponse;
import com.example.inin.injob.models.cv1.town.TownResponse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalInfo extends Fragment {
//    Context context = this.getActivity();
//    Toast toast = Toast.makeText(context, "Exito", Toast.LENGTH_SHORT);

    Spinner s;
    Spinner spinnerNacionalidades;
    Spinner spinnerVisa;
    Spinner spinnerLicencia;

    Button buttonDPI;
    Button buttonPenales;
    Button buttonPoliciacos;
    int selectedImageType=0;


    String urlImage = "https://app.inin.global/api/cv/photo";



    private String[] arraySpinnerGenero;

    private String[] arraySpinnerNacionalidades;

    private String[] arraySpinnerLicencia;

    private String[] arraySpinnerVisa;
    private String [] arraySpinnerCountry;
    private String[] arrayDepartment;
    private String[] arrayTown;
    private DepartmentResponse departmentResponse = new DepartmentResponse();
    private TownResponse townResponse = new TownResponse();
    private Boolean isChangedCv1 = false;
//    Bitmap bitmap;
//    ProgressDialog progress;


    EditText editTextName;

    Spinner s5;
    Spinner s7;
    ImageView imageView;
    EditText editTextLName;
    EditText editTextdpi;
    EditText editTextcel;
    EditText editTexttel;
    EditText editTextDir;
    EditText editTextZona;
    EditText editTextNac;
    Spinner spinner;


    public PersonalInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_personal_info, container, false);
        buttonDPI        = (Button)root.findViewById(R.id.uploadImageDPI);
        buttonPenales    = (Button)root.findViewById(R.id.uploadPenalesButton);
        buttonPoliciacos = (Button)root.findViewById(R.id.uploadPoliciacosButton);
        editTextName = root.findViewById(R.id.editTextName);
        s = (Spinner) root.findViewById(R.id.generos);
        spinnerNacionalidades = (Spinner) root.findViewById(R.id.nacionalidad);
        spinnerLicencia = (Spinner) root.findViewById(R.id.licencia);
        spinnerVisa = (Spinner) root.findViewById(R.id.visa);
        s5 = (Spinner) root.findViewById(R.id.pais);
        s7 = (Spinner) root.findViewById(R.id.municipio);
        imageView = (ImageView) root.findViewById(R.id.imageView2);
        editTextLName = root.findViewById(R.id.editTextLastName);
        editTextdpi = root.findViewById(R.id.editTextDPI);
        editTextcel = root.findViewById(R.id.editTextCell);
        editTexttel = root.findViewById(R.id.editTextPhone);
        editTextDir = root.findViewById(R.id.editTextDireccion);
        editTextZona = root.findViewById(R.id.editTextZona);
        editTextNac = root.findViewById(R.id.birthday);
        spinner = (Spinner) root.findViewById(R.id.departamento);

        if(getActivity()!=null)
        {
            FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    attemptSaveCv1(editTextLName.getText().toString(),editTextcel.getText().toString(),editTextDir.getText().toString(),
                            editTextdpi.getText().toString(),editTextName.getText().toString(),editTexttel.getText().toString(),
                            editTextZona.getText().toString(), spinnerNacionalidades.getSelectedItemPosition()+1);

                }
            });

        }

        buttonDPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageType = 1;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Selecciona imagen"),999);
            }
        });

        buttonPenales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageType = 2;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Selecciona imagen"),999);
            }
        });

        buttonPoliciacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageType = 3;
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Selecciona imagen"),999);
            }
        });

        getCV();
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String fileType;
        if(requestCode==999 && resultCode== RESULT_OK && data!=null)
        {
            try{
                ContentResolver cR = getContext().getContentResolver();
                Uri filepath = data.getData();
                fileType = cR.getType(filepath);
                uploadFile(filepath,fileType);

//                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),filepath);



            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }



    private void uploadFile(Uri fileUri, String fileType) {

//        try {
//             originalFile = new File(new URI(fileUri.getPath()));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
        File  originalFile=null;
        String filePath="";
        try {
             filePath= PathUtil.getPath(getContext(),fileUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        originalFile = new File(filePath);



        RequestBody filePart = RequestBody.create(MediaType.parse(fileType),originalFile);

        MultipartBody.Part file = MultipartBody.Part.createFormData("file", originalFile.getName(),filePart);

//        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://app.inin.global/api/cv/").addConverterFactory(GsonConverterFactory.create());

//        Retrofit retrofit = builder.build();

        ApiService client = RetrofitClient.getClient("https://app.inin.global/api/cv/").create(ApiService.class);
        Call<ResponseBody> call = null;
        switch (selectedImageType)
        {
            case 1:
                call = client.uploadDPI(file,"Bearer "+UserData.Instance().getToken());
                break;
            case 2:
                call = client.uploadCriminalRecords(file,"Bearer "+UserData.Instance().getToken());
                break;
            case 3:
                call = client.uploadPoliceRecords(file,"Bearer "+UserData.Instance().getToken());
                break;
            default:
                call = client.uploadDPI(file,"Bearer "+UserData.Instance().getToken());
                break;
        }

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                Toast toast = Toast.makeText(getActivity(), response.message(), Toast.LENGTH_LONG);
//                toast.show();

                if(response.code()==200)
                {
                    Toast.makeText(getContext(),"¡Imagen guardada exitosamente!",Toast.LENGTH_LONG).show();
//                    Snackbar.make(getView(), , Snackbar.LENGTH_LONG)
//                            .setAction("", null).show();
                }
                else if(response.code()==413)
                {
                    Toast.makeText(getContext(),"¡Imagen demasiado grande, por favor selecciona una imagen más pequeña!",Toast.LENGTH_LONG).show();

//                    Snackbar.make(getView(), , Snackbar.LENGTH_LONG)
//                            .setAction("", null).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(getContext(),"Lo sentimos, ¡por favor intente en un momento de nuevo!",Toast.LENGTH_LONG).show();

//                    Snackbar.make(getView(), "Lo sentimos, ¡por favor intente en un momento de nuevo!", Snackbar.LENGTH_LONG)
//                            .setAction("", null).show();

//                Toast toast = Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG);
//                toast.show();

            }
        });

    }



    private void getCV()
    {
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

        MySingleton.getInstance(this.getContext()).addToRequestQueue(jsObjRequest);
    }

    public void getDepartment(Integer country)
    {
        String url = "https://app.inin.global/api/country/"+ country +"/department";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        new getDepartmentJson().execute(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
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

        MySingleton.getInstance(this.getContext()).addToRequestQueue(jsObjRequest);
    }

    public void getTown(Long country, Long department)
    {
        String url = "https://app.inin.global/api/country/"+ country +"/department/"+department+"/town";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        new getTownJson().execute(response);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
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

        MySingleton.getInstance(this.getContext()).addToRequestQueue(jsObjRequest);
    }


    public class getTownJson extends AsyncTask<JSONObject,Void,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
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
            Gson gson = new Gson();
            townResponse= gson.fromJson(jsonObjects[0].toString(), TownResponse.class);
            return null;
        }
    }

    public class getDepartmentJson extends AsyncTask<JSONObject,Void,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {


                ArrayAdapter<DatumDepartment> adapter = new ArrayAdapter<DatumDepartment>(getContext(),android.R.layout.simple_spinner_item,departmentResponse.getData()); // initialize the adapter
                spinner.setAdapter(adapter);

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
            Gson gson = new Gson();
            departmentResponse= gson.fromJson(jsonObjects[0].toString(), DepartmentResponse.class);
            return null;
        }
    }

    public class parseJson extends AsyncTask<JSONObject,Void,Void>
    {



        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(Void aVoid) {

            setDataInView();
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
            Gson gson = new Gson();
            CvResponse cvResponse = gson.fromJson(jsonObjects[0].toString(), CvResponse.class);
            UserData.Instance().setCv1(cvResponse.getData());
            return null;
        }
    }

    public String getLicenseValue(String request)
    {
        switch (request)
        {
            case "No poseo Licencia de Conducir":
                return "N";
            case "Liviana":
                return "C";
            case "Comercial":
                return "B";
            case "Profesional":
                return "A";
            case "Motocicleta":
                return "M";
            case "Maquinaria Agrícola":
                return "E";
            default:
                return "Invalid";
        }
    }

    public int getLicenseIndexByValue(String request)
    {
        switch (request)
        {
            case "N":
                return 0;
            case "C":
                return 1;
            case "B":
                return 2;
            case "A":
                return 3;
            case "M":
                return 4;
            case "E":
                return 5;
            default:
                return 0;
        }
    }



    public void setDataInView() {

           this.arraySpinnerNacionalidades = new String[]{"Guatemalteca", "Mexicana", "Salvadoreña", "Hondureña", "Nicaraguense", "Costaricense",
                   "Estadounidense", "Canadiense", "Española","Británica","Alemana","Beliceña", "Surcoreana", "Francesa", "Colombiana","Panameña",
                   "Cubana", "Brasileña","Argentina","Venezolana","Chilena","China","Taiwanesa","Japonesa","Boliviana"};

           this.arraySpinnerLicencia = new String[]{"No poseo Licencia de Conducir","Liviana", "Comercial", "Profesional",
                   "Motocicleta", "Maquinaria Agrícola"};

           this.arraySpinnerVisa = new String[]{"Si", "No"};

           this.arraySpinnerCountry = new String[]{"Guatemala","El Salvador","Honduras",
                   "Nicaragua","Costa Rica", "México", "Colombia", "Venezuela","Ecuador",
                    "Perú","Argentina","Chile","Panamá","España"};


           editTextName.setText(UserData.Instance().getCv1().getNombre());

           editTextLName.setText(UserData.Instance().getCv1().getApellido());

           editTextdpi.setText(UserData.Instance().getCv1().getIdentificacion());

           editTextcel.setText(UserData.Instance().getCv1().getCelular());


           editTexttel.setText(UserData.Instance().getCv1().getTelefono());

           editTextDir.setText(UserData.Instance().getCv1().getDireccion());

           editTextZona.setText(UserData.Instance().getCv1().getZona());


           if(UserData.Instance().getCv1().getNacimiento()!=null)
           {
               Date date = new Date(UserData.Instance().getCv1().getNacimiento());
               SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
               String dateText = df2.format(date);
               editTextNac.setText(dateText);
           }

           if(UserData.Instance().getCv1().getGenero()!=null)
           {
               if(UserData.Instance().getCv1().getGenero().equals("H")){
                   this.arraySpinnerGenero = new String[] { "Masculino", "Femenino"};
               }
               else
               {
                   this.arraySpinnerGenero = new String[] { "Femenino", "Masculino"};
               }
           }
           else {
               this.arraySpinnerGenero = new String[] { "Masculino", "Femenino"};
           }


           if(this.getContext()!=null)
           {
               ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                       android.R.layout.simple_spinner_item, arraySpinnerGenero);
               s.setAdapter(adapter);

               ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getContext(),
                       android.R.layout.simple_spinner_item, arraySpinnerNacionalidades);
               spinnerNacionalidades.setAdapter(adapter2);
               spinnerNacionalidades.setSelection(UserData.Instance().getCv1().getNacionalidad());
           }



           if(UserData.Instance().getCv1().getNacionalidad()!=null)
           {
               spinnerNacionalidades.setSelection(UserData.Instance().getCv1().getNacionalidad() - 1);
           }

            if(this.getContext()!=null)
            {
                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(),
                        android.R.layout.simple_spinner_item, arraySpinnerLicencia);
                spinnerLicencia.setAdapter(adapter3);
                spinnerLicencia.setSelection(getLicenseIndexByValue(UserData.Instance().getCv1().getLicencia()));
//        spinnerLicencia.setSelection(UserData.Instance().getCv1().getNacionalidad() - 1);

                ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(),
                        android.R.layout.simple_spinner_item, arraySpinnerVisa);
                spinnerVisa.setAdapter(adapter4);

                ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this.getActivity(),
                        android.R.layout.simple_spinner_item, arraySpinnerCountry);

                s5.setAdapter(adapter5);
                s5.setSelection(UserData.Instance().getCv1().getPais()-6);

                getDepartment(UserData.Instance().getCv1().getPais());

                s7.setAdapter(adapter5);
            }


           if(UserData.Instance().getCv1().getVisa()!=null)
           {
               if(UserData.Instance().getCv1().getVisa() )
               {
                   spinnerVisa.setSelection(0);
               }
               else {
                   spinnerVisa.setSelection(1);
               }
           }
           else {
               spinnerVisa.setSelection(1);
           }









           Context context = getActivity();
           if(UserData.Instance().getCv1().getFoto()!=null)
           {
               Picasso.with(context).load("https://s3.amazonaws.com/rrhh-images/cv/photo/"+UserData.Instance().getCv1().getFoto()).into(imageView);
           }
           else {
               Picasso.with(context).load("https://www.shareicon.net/data/2016/09/01/822711_user_512x512.png").into(imageView);
           }

           editTextName.addTextChangedListener(new TextWatcher() {
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
                    isChangedCv1 = true;
               }
           });

           editTextLName.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });

           editTextNac.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });

           editTextdpi.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });

           editTextcel.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });

           editTexttel.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });

           editTextDir.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });

           editTextZona.addTextChangedListener(new TextWatcher() {
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
                   isChangedCv1 = true;
               }
           });






       }

       public Integer getLicenseIndex(String data)
       {
           switch (data)
           {
               case "N":
                   return 1;

               case "C":
                   return 2;

               case "B":
                   return 3;

               case "A":
                   return 4;

               case "M":
                   return 5;

               case "E":
                   return 6;

               default:
                   return 1;
           }
       }


    private void attemptSaveCv1(String apellido, String celular, String direccion, String dpi, String nombre,
                                String telefono, String zona, int citizenship)
    {

        Context context = getActivity();
        Boolean responseAttempt = false;
        final ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Guardando información, por favor espere");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        Gson gson = new Gson();

        String url = "https://app.inin.global/api/cv";
        JSONObject jsonBody = new JSONObject();

        try{
//            jsonBody.put("apellido", email);
//            jsonBody.put("password", password);
            DataCV1 dataCV1 = UserData.Instance().getCv1();
            dataCV1.setApellido(apellido);
            dataCV1.setCelular(celular);
            dataCV1.setDireccion(direccion);
            dataCV1.setIdentificacion(dpi);
            dataCV1.setNombre(nombre);
            dataCV1.setTelefono(telefono);
            dataCV1.setZona(zona);
            dataCV1.setNacionalidad(citizenship);

            if(spinnerVisa.getSelectedItemPosition()==0)
            {
                dataCV1.setVisa(true);
            }
            else
            {
                dataCV1.setVisa(false);
            }

            if(s.getSelectedItem().toString().equals("Masculino"))
            {
                dataCV1.setGenero("H");
            }
            else {
                dataCV1.setGenero("M");
            }

            dataCV1.setLicencia(getLicenseValue(spinnerLicencia.getSelectedItem().toString()));


            jsonBody = new JSONObject(gson.toJson(dataCV1));

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        progress.dismiss();
                        Snackbar.make(getView(), "Datos guardados exitosamente!", Snackbar.LENGTH_LONG)
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
