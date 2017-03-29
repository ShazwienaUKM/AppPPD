package com.myxlab.shida_minie.msmpu3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    public static final String KEY_NAME = "KEY_NAME";
    public static final String ID_PENGGUNA = "ID_PENGGUNA";
    AutoCompleteTextView ukmPer;
    EditText pswd;
    Button signin;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ukmPer = (AutoCompleteTextView)findViewById(R.id.ukmper);
        pswd = (EditText)findViewById(R.id.password);
        signin = (Button)findViewById(R.id.email_sign_in_button);

        requestQueue = Volley.newRequestQueue(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://lrgs.ftsm.ukm.my/users/a146208/msmpuv2_5.2/public/api/v1/login";

                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            // Toast.makeText(LoginActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                            String tokenString = jsonObject.getString("token");
                            //String idPengguna = jsonObject.getString("id");//cm ne nk dpt kn nie
                            if (tokenString != null){
                                Intent i= new Intent(LoginActivity.this, MainActivity.class);
                                i.putExtra(KEY_NAME, tokenString);
                                // i.putExtra(ID_PENGGUNA, idPengguna);
                                startActivity(i);
                            }
                            /*if (jsonObject.names().get(0).equals("id_pengguna") && jsonObject.names().get(1).equals("password")){
                                Toast.makeText(LoginActivity.this, "Success" + jsonObject.getString("id_pengguna") + jsonObject.getString("password"), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(LoginActivity.this,DanaActivity2.class);
                                i.putExtra(KEY_NAME,ukmPer.getText());
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error",error.toString());
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashMap = new HashMap<String, String>();
                        hashMap.put("id_pengguna",ukmPer.getText().toString());
                        hashMap.put("password",pswd.getText().toString());

                        return hashMap;
                    }
                };

                requestQueue.add(request);





                /*Intent i = new Intent(LoginActivity.this,DanaActivity2.class);
                i.putExtra(KEY_NAME,pswd.getText());
                startActivity(i);*/
            }
        });
    }
}

