package com.example.beautycare;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import com.example.beautycare.databinding.ActivityDetailedComunidadBinding;

public class DetailedComunidadActivity extends AppCompatActivity {
    ActivityDetailedComunidadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedComunidadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            int ingredients = intent.getIntExtra("ingredients", R.string.maggiIngredients);
            int desc = intent.getIntExtra("desc", R.string.maggieDesc);
            int image = intent.getIntExtra("image", R.drawable.login);
            binding.detailName.setText(name);
            binding.detailTime.setText(time);
            binding.detailDesc.setText(desc);
            binding.detailIngredients.setText(ingredients);
            binding.detailImage.setImageResource(image);
        }
    }
}