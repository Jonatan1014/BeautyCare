package com.example.beautycare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class PerfilFragment extends Fragment {

    Button cerrar_sesion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_perfil, container, false);
        cerrar_sesion = (Button) vista.findViewById(R.id.btn_cerrarsesion);

        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cerrarSesion();
            }
        });



        return vista;
    }
    private void cerrarSesion(){
        Usuario usuario = new Usuario();
        usuario.clear(getContext()); // Utiliza getContext() para obtener el contexto del fragmento

        Toast.makeText(getContext(), "Cerrando sesión", Toast.LENGTH_SHORT).show();

        // Una vez cerrada la sesión, nos dirigimos a la actividad de inicio de sesión nuevamente
        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
    }



}