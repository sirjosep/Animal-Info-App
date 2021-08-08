package com.josepvictorr.animalinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TypedArray dataAnimalPic;
    private TypedArray dataAnimalHead;
    private String[] dataAnimalName;
    private String[] dataAnimalHabitat;
    private String[] dataAnimalFood;
    private String[] dataAnimalAge;
    private String[] dataBiologyName;
    private String[] dataAnimalBBTB;
    private AnimalAdapter animalAdapter;
    private ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        ListView listView = findViewById(R.id.animal_list);
        animalAdapter = new AnimalAdapter(this);
        listView.setAdapter(animalAdapter);

        ImageButton btnProfile = findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(view -> {
            Intent homeProfileIntent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(homeProfileIntent);
        });

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Detail detail = new Detail();
                detail.setAnimalName(animals.get(i).getAnimalName());
                detail.setAnimalFood(animals.get(i).getAnimalFood());
                detail.setAnimalHabitat(animals.get(i).getAnimalHabitat());
                detail.setAnimalPic(animals.get(i).getAnimalPic());
                detail.setAnimalAge(animals.get(i).getAnimalAge());
                detail.setAnimalBBTB(animals.get(i).getAnimalBBTB());
                detail.setBiologyName(animals.get(i).getBiologyName());

                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                detailIntent.putExtra(DetailActivity.EXTRA_DETAIL, detail);
                startActivity(detailIntent);
            }
        });
    }

    private void prepare(){
        dataAnimalHead = getResources().obtainTypedArray(R.array.animal_head);
        dataAnimalPic = getResources().obtainTypedArray(R.array.animal_pic);
        dataAnimalName = getResources().getStringArray(R.array.animal_name);
        dataAnimalHabitat = getResources().getStringArray(R.array.animal_habitat);
        dataAnimalFood = getResources().getStringArray(R.array.animal_food);
        dataAnimalAge = getResources().getStringArray(R.array.animal_age);
        dataAnimalBBTB = getResources().getStringArray(R.array.animal_weight_height);
        dataBiologyName = getResources().getStringArray(R.array.animal_biology);
    }

    private void addItem(){
        animals = new ArrayList<>();
        for (int i = 0; i < dataAnimalHead.length(); i++){
            Animal animal = new Animal();
            animal.setAnimalHead(dataAnimalHead.getResourceId(i, -1));
            animal.setAnimalPic(dataAnimalPic.getResourceId(i, -1));
            animal.setAnimalName(dataAnimalName[i]);
            animal.setAnimalHabitat(dataAnimalHabitat[i]);
            animal.setAnimalFood(dataAnimalFood[i]);
            animal.setAnimalAge(dataAnimalAge[i]);
            animal.setAnimalBBTB(dataAnimalBBTB[i]);
            animal.setBiologyName(dataBiologyName[i]);
            animals.add(animal);
        }
        animalAdapter.setAnimals(animals);
    }
}