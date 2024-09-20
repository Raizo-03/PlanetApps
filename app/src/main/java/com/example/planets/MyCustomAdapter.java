package com.example.planets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //using custom layouts -> MyCustomAdapter
    //using custom Objects -> extends ArrayAdapter<Planet>

    private ArrayList<Planet> planetsArrayList;
    Context context;


    public MyCustomAdapter(Context context, ArrayList<Planet> planetsArrayList) {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;

    }
    //View Holder CLass - used to cache references to the views within an item layout
        //so that they dont need to be repeatedly looked up when scrolling the list

    private static class MyViewHolder{
        ImageView planetImg;
        TextView planetName;
        TextView moonCount;

    }

    //get view to create and return a view for a specific item in the list

    public View getView(int position, View convertView, ViewGroup parent) {
        //get the planet object for the current position
        Planet planet = getItem(position);

        //Inflate layout
        MyViewHolder myViewHolder;
        final View result;


        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.planet_description);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(myViewHolder);
        } else {

            //if the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        //Getting data from the model class
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());

        return convertView;
    }




}
