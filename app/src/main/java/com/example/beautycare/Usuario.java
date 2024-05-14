package com.example.beautycare;


import android.content.Context;
import android.content.SharedPreferences;

public class Usuario {
    String Name, Email;


    public String getName() {
        return Name;
    }

    public void setName(String user) {
        this.Name = user;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    // Método para guardar los datos en SharedPreferences
    public void guardarDatos(Context context) {
        // Obtener una referencia al SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserInformation", Context.MODE_PRIVATE);
        // Editar el SharedPreferences para guardar los datos
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", Name);
        editor.putString("email", Email);
        editor.apply(); // Aplicar los cambios
    }

    public void clear(Context context) {
        // Obtener una referencia al SharedPreferences usando el contexto proporcionado
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserInformation", Context.MODE_PRIVATE);
        // Limpiar las variables
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }


}
