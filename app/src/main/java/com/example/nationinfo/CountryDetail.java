package com.example.nationinfo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class CountryDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView flag = findViewById(R.id.imageView);
        TextView name = findViewById(R.id.name_value);
        TextView population = findViewById(R.id.population_value);
        TextView area = findViewById(R.id.area_value);

        CountryDTO country = (CountryDTO) getIntent().getSerializableExtra("country");

        Picasso.get().load("http://www.geonames.org/flags/x/"+ country.code.toLowerCase() +".gif").into(flag);
        name.setText(country.name);
        population.setText(country.population);
        area.setText(country.area);
    }
}
