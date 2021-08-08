package com.josepvictorr.animalinfoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DETAIL = "extra_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().hide();


        TextView detailNameReceived = findViewById(R.id.detail_name);
        TextView foodTypeReceived = findViewById(R.id.food_type);
        TextView animalHabitatReceived = findViewById(R.id.context_habitat);
        TextView animalAgeReceived = findViewById(R.id.animal_age);
        TextView animalWeightHeightReceived = findViewById(R.id.animal_weight_height);
        TextView biologyNameReceived = findViewById(R.id.biology_name);
        CircleImageView detailPicReceived = findViewById(R.id.detail_pic);

        ImageButton backHomeDetail = findViewById(R.id.back_home_detail);
        backHomeDetail.setOnClickListener(view -> {
            Intent backHomeDetailIntent = new Intent(DetailActivity.this, MainActivity.class);
            backHomeDetailIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(backHomeDetailIntent);
            finish();
        });

        Button btnShare = findViewById(R.id.btn_share);
        btnShare.setOnClickListener(view -> {
            Intent shareWaIntent = new Intent(Intent.ACTION_SEND);
            shareWaIntent.setType("text/plain");
            shareWaIntent.putExtra(Intent.EXTRA_TEXT,
                    detailNameReceived.getText() + " memiliki nama biology " + biologyNameReceived.getText() + ", "
                    + foodTypeReceived.getText() + "... Penasaran apa saja ciri - ciri " + detailNameReceived.getText() + " ? ayo download AnimalInfoApp sekarang juga!");
            shareWaIntent.setPackage("com.whatsapp");
            try {
                startActivity(shareWaIntent);
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(), "Whatsapp tidak di temukan", Toast.LENGTH_SHORT).show();
            }
        });

        Detail detail = getIntent().getParcelableExtra(EXTRA_DETAIL);

        String name = detail.getAnimalName();
        detailNameReceived.setText(name);

        String foodType = detail.getAnimalFood();
        foodTypeReceived.setText(foodType);

        String habitat = detail.getAnimalHabitat();
        animalHabitatReceived.setText(habitat);

        String animalAge = detail.getAnimalAge();
        animalAgeReceived.setText(animalAge);

        String weightHeight = detail.getAnimalBBTB();
        animalWeightHeightReceived.setText(weightHeight);

        String biologyName = " ( " + detail.getBiologyName() + " ) ";
        biologyNameReceived.setText(biologyName);

        Glide.with(this)
            .load(detail.getAnimalPic())
            .into(detailPicReceived);
    }

}