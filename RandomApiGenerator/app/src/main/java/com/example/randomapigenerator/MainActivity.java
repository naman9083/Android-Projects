package com.example.randomapigenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

        private String url;
        private ImageView imageView;

        public ImageLoadTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL urlConnection = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlConnection
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            super.onPostExecute(result);
            imageView.setImageBitmap(result);
        }

    }
    TextView name,gender,email,username,dob ,address;
    ImageView userImg;

    public String getParticular(JSONObject response,int index,String particular1, String particular2){
        String s = "";
        try {
           s += response.getJSONArray("results").getJSONObject(index).getJSONObject(particular1).optString(particular2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }
    public String getParticular(JSONObject response,int index,String particular1){
        String s = "";
        try {
           s += response.getJSONArray("results").getJSONObject(index).optString(particular1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.textView2);
        gender = findViewById(R.id.textView3);
        dob = findViewById(R.id.textView4);
        email = findViewById(R.id.textView5);
        username = findViewById(R.id.textview6);
        address = findViewById(R.id.textView7);
        userImg =  findViewById(R.id.imageView2);
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"https://randomuser.me/api/", null, new Response.Listener<JSONObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONObject response) {
                name.setText((getParticular(response,0,"name","first")+" "+getParticular(response,0,"name","last")).toUpperCase(Locale.ROOT));
                gender.setText("GENDER: "+ getParticular(response,0,"gender").toUpperCase(Locale.ROOT));
                dob.setText("DATE OF BIRTH: "+(getParticular(response,0,"dob","date")).substring(0,10));
                email.setText("EMAIL: "+getParticular(response,0,"email"));
                username.setText("USERNAME: "+getParticular(response,0,"login","username"));
                address.setText("ADDRESS: "+(getParticular(response,0,"location","city")+", "+
                        getParticular(response,0,"location","state")+", "+
                                getParticular(response,0,"location","country")).toUpperCase(Locale.ROOT));
                String s;
                s = getParticular(response,0,"picture","large");
                new ImageLoadTask(s, userImg).execute();
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Something went wrong"); }
        });
//        requestQueue.add(jsonObjectRequest);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> requestQueue.add(jsonObjectRequest));



    }
}