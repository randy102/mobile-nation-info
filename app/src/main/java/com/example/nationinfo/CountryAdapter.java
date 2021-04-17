package com.example.nationinfo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class CountryAdapter extends ArrayAdapter<CountryDTO> {
    Context context;

    public CountryAdapter(Context context, ArrayList<CountryDTO> CountryDTOs) {
        super(context, 0, CountryDTOs);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.country_name);

        // Populate the data into the template view using the data object
        CountryDTO country = getItem(position);
        tvName.setText(country.name);
        tvName.setTag(country);
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountryDTO country = (CountryDTO) v.getTag();
                Intent intent = new Intent(context, CountryDetail.class);
                intent.putExtra("country", country);
                context.startActivity(intent);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

}