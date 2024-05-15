package com.example.beautycare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapterItems extends ArrayAdapter<ListDataItems> {
    public ListAdapterItems(@NonNull Context context, ArrayList<ListDataItems> dataArrayList) {
        super(context, R.layout.list_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListDataItems listDataItems = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.listImage);
        TextView listName = view.findViewById(R.id.listName);
        TextView listPrecio = view.findViewById(R.id.listPrecio);

        listImage.setImageResource(listDataItems.image);
        listName.setText(listDataItems.name);
        listPrecio.setText(listDataItems.precio);

        return view;
    }
}