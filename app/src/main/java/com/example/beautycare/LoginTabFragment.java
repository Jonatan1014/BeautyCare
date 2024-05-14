package com.example.beautycare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginTabFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener  {
    RequestQueue rq;
    JsonRequest jrq;
    EditText user, pass;
    Button btn_login;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login_tab, container, false);
        View vista = inflater.inflate(R.layout.fragment_login_tab, container, false);
        user = (EditText) vista.findViewById(R.id.login_email);
        pass = (EditText) vista.findViewById(R.id.login_password);
        rq = Volley.newRequestQueue(getContext());
        btn_login = (Button) vista.findViewById(R.id.login_button);


        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {login();}
        });

        return vista;

    }

    private void login(){
        String url = "https://bd-app.000webhostapp.com/sesion.php?user="+user.getText().toString()+"&pwd="+pass.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
        Usuario usuario = new Usuario();
        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonobject = null;
        try {
            jsonobject = jsonArray.getJSONObject(0);
            usuario.setName(jsonobject.optString("name"));
            usuario.setEmail(jsonobject.optString("user"));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}