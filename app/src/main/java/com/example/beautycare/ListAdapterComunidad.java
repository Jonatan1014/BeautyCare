package com.example.beautycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapterComunidad extends ArrayAdapter<ListDataComunidad> {
    public ListAdapterComunidad(@NonNull Context context, ArrayList<ListDataComunidad> dataArrayList) {
        super(context, R.layout.list_comunidad, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListDataComunidad listDataComunidad = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_comunidad, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.listImage);
        TextView listName = view.findViewById(R.id.listName);
        TextView listTime = view.findViewById(R.id.listTime);

        listImage.setImageResource(listDataComunidad.image);
        listName.setText(listDataComunidad.name);
        listTime.setText(listDataComunidad.time);

        return view;
    }
}