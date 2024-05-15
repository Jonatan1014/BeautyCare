package com.example.beautycare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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


public class SignupTabFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;
    Button signup;
    EditText username,email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_singup_tab, container, false);
        rq = Volley.newRequestQueue(getContext());
        username = view.findViewById(R.id.signup_name);
        email = view.findViewById(R.id.signup_email);
        password = view.findViewById(R.id.signup_password);

        signup = view.findViewById(R.id.signup_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });



        return view;
    }

    private void signup() {

        String url = "https://bd-app.000webhostapp.com/registrar.php?names=" + username.getText().toString() + "&user=" + email.getText().toString() + "&pwd=" + password.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);


    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Toast.makeText(getContext(), "!Conexion Fallida! revisa tu conexion a internet", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Cuenta Creada Con Exito", Toast.LENGTH_SHORT).show();
        Usuario usuario = new Usuario();
        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonobject = null;
        try {
            jsonobject = jsonArray.getJSONObject(0);
            usuario.setName(jsonobject.optString("username"));
            usuario.setEmail(jsonobject.optString("email"));
            usuario.guardarDatos(getContext());

            // Una vez valido el inicio de sesion nos vamos al index
            Intent intent = new Intent(getActivity(), Index.class);
            startActivity(intent);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}