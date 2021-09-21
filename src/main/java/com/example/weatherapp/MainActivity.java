package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView temp,tvrain,tvpressure,tvsunrise,tvsunset,tvwind,label ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.editt);
        temp = (TextView)findViewById(R.id.temptext);
        tvrain = (TextView)findViewById(R.id.tvrain);
        tvpressure = (TextView)findViewById(R.id.tvpressure);
        tvsunrise = (TextView)findViewById(R.id.tvsunrise);
        tvsunset = (TextView)findViewById(R.id.tvsunset);
        tvwind = (TextView)findViewById(R.id.tvwind);
        label = (TextView)findViewById(R.id.label);

    }

    public void gettemp(View v) {
        String apikey = "e2260f3e075f08be2253dcb3a5a142a2";
        String city = et.getText().toString();
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e2260f3e075f08be2253dcb3a5a142a2";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String temperature = object.getString("temp");
                    Double dtemp = Double.parseDouble(temperature)-273.15;
                    if(dtemp>=0)
                        temp.setText(dtemp.toString().substring(0,2)+"°C");
                    else
                        temp.setText(dtemp.toString().substring(0,3)+"°C");
                    label.setText("Temperature");

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    public void gethumidity(View v) {
        String apikey = "e2260f3e075f08be2253dcb3a5a142a2";
        String city = et.getText().toString();
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e2260f3e075f08be2253dcb3a5a142a2";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String humidity = object.getString("humidity");
                    temp.setText(humidity);
                    label.setText("Humidity");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    public void getpressure(View v) {
        String apikey = "e2260f3e075f08be2253dcb3a5a142a2";
        String city = et.getText().toString();
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e2260f3e075f08be2253dcb3a5a142a2";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String pressure = object.getString("pressure");
                    temp.setText(pressure+"hPa");
                    label.setText("Pressure");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    public void gettempmax(View v) {
        String apikey = "e2260f3e075f08be2253dcb3a5a142a2";
        String city = et.getText().toString();
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e2260f3e075f08be2253dcb3a5a142a2";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String temp_max = object.getString("temp_max");
                    Double dtemp_max = Double.parseDouble(temp_max)-273.15;
                    if(dtemp_max>=0)
                        temp.setText(dtemp_max.toString().substring(0,2)+"°C");
                    else
                        temp.setText(dtemp_max.toString().substring(0,3)+"°C");
                    label.setText("Max. Temperature");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    public void gettempmin(View v) {
        String apikey = "e2260f3e075f08be2253dcb3a5a142a2";
        String city = et.getText().toString();
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e2260f3e075f08be2253dcb3a5a142a2";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String temp_min = object.getString("temp_min");
                    Double dtemp_min = Double.parseDouble(temp_min)-273.15;
                    if(dtemp_min>=0)
                        temp.setText(dtemp_min.toString().substring(0,2)+"°C");
                    else
                        temp.setText(dtemp_min.toString().substring(0,3)+"°C");
                    label.setText("Min. Temperature");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
    public void getwindspeed(View v) {
        String apikey = "e2260f3e075f08be2253dcb3a5a142a2";
        String city = et.getText().toString();
        String apiurl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e2260f3e075f08be2253dcb3a5a142a2";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("wind");
                    String windspeed = object.getString("speed");
                    temp.setText(windspeed+"knots");
                    label.setText("Wind Speed");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }
}