package com.example.planets;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private MyCustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Data Source : ArrayList<Planet>
        planetsArrayList = new ArrayList<>();
        Planet planet1 = new Planet("Venus", "0 moons", R.drawable.venus);
        Planet planet2 = new Planet("Earth", "1 moons", R.drawable.earth);
        Planet planet3 = new Planet("Mars", "2 moons", R.drawable.mars);
        Planet planet4 = new Planet("Jupiter", "79 moons", R.drawable.jupiter);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);

        //Adapter
        customAdapter = new MyCustomAdapter(getApplicationContext(), planetsArrayList);

        //AdapterView: listview
        listView = findViewById(R.id.listview);
        listView.setAdapter(customAdapter);
    }
}