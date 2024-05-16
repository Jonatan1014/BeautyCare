package com.example.beautycare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import com.example.beautycare.databinding.FragmentComunidadBinding;
import java.util.ArrayList;

public class ComunidadFragment extends Fragment {

    FragmentComunidadBinding binding;
    ListAdapterComunidad listAdapterComunidad;
    ArrayList<ListDataComunidad> dataArrayList = new ArrayList<>();
    ListDataComunidad listDataComunidad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentComunidadBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        int[] imageList = {R.drawable.estelista1, R.drawable.estilista2, R.drawable.estilista5, R.drawable.estilista3, R.drawable.estilista4,R.drawable.estelista1, R.drawable.estilista2, R.drawable.estilista5, R.drawable.estilista3, R.drawable.estilista4};
        int[] ingredientList = {R.string.Sofiaalvarez, R.string.margaritalopez,R.string.jhoathannenemann,R.string.Cristianmesa,R.string.ultimoestilista,R.string.Sofiaalvarez, R.string.margaritalopez,R.string.jhoathannenemann,R.string.Cristianmesa,R.string.ultimoestilista};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.chocolateDesc,R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.chocolateDesc};
        String[] nameList = {"Sofia Alvarez", "Margarita Lopez", "Jonathan Nenemann", "Cristian Mesa", "Ultimo Estilista","Sofia Alvarez", "Margarita Lopez", "Jonathan Nenemann", "Cristian Mesa", "Ultimo Estilista"};
        String[] timeList = {"Barbero", "Estilsta Profesional", "Barbero Especializado","Modista Profesional", "Barbero Especializado","Barbero", "Estilsta Profesional", "Barbero Especializado","Modista Profesional", "Barbero Especializado"};

        for (int i = 0; i < imageList.length; i++) {
            listDataComunidad = new ListDataComunidad(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listDataComunidad);
        }

        listAdapterComunidad = new ListAdapterComunidad(requireActivity(), dataArrayList);
        binding.listviewComunidad.setAdapter(listAdapterComunidad);

        binding.listviewComunidad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(requireContext(), DetailedComunidadActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });

        return view;
    }
}
