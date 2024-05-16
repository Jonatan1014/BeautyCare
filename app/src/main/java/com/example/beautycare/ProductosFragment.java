package com.example.beautycare;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import com.example.beautycare.databinding.FragmentProductosBinding;
import java.util.ArrayList;

public class ProductosFragment extends Fragment {

    FragmentProductosBinding binding;
    ListAdapterItems listAdapterItems;
    ArrayList<ListDataItems> dataArrayList = new ArrayList<>();
    ListDataItems listDataItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductosBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        int[] imageList = {R.drawable.gel1, R.drawable.gel2, R.drawable.cremacabello1, R.drawable.cremacabello2, R.drawable.botellabarberia, R.drawable.botelladescuento, R.drawable.comboshampo, R.drawable.esmalte1,R.drawable.esmalte2 };
        int[] ingredientList = {R.string.pastaIngredients, R.string.maggiIngredients,R.string.cakeIngredients,R.string.pancakeIngredients,R.string.pizzaIngredients, R.string.burgerIngredients, R.string.friesIngredients,R.string.burgerIngredients, R.string.friesIngredients};
        int[] descList = {R.string.pastaDesc, R.string.maggieDesc, R.string.cakeDesc,R.string.pancakeDesc,R.string.pizzaDesc, R.string.burgerDesc, R.string.friesDesc,R.string.burgerDesc, R.string.friesDesc};
        String[] nameList = {"Gel Ego", "Gel Moco", "Crema Sedal", "Crema Pantene", "Botella De Barberia","Combo Especial", "Combo Capilar", "Esmalte Masglo Rosa", "Esmalte Gris"};
        String[] precioList = {"30.000", "25.000", "26.000", "45.000","10.000",  "60.000", "45.000", "30.000", "102.000"};

        for (int i = 0; i < imageList.length; i++) {
            listDataItems = new ListDataItems(nameList[i], precioList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listDataItems);
        }

        listAdapterItems = new ListAdapterItems(requireActivity(), dataArrayList);
        binding.listviewProductos.setAdapter(listAdapterItems);

        binding.listviewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(requireContext(), DetailedItemsActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("precio", precioList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });

        return view;
    }
}
