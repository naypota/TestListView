package com.example.user.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.testlistview.Model.Animal;

public class AnimalDetial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detial);

        ImageView animalImageView = (ImageView) findViewById(R.id.animal_image_view);
        TextView nameTextView = (TextView) findViewById(R.id.name_text_view);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        AnimalData animalData = AnimalData.getInstance();
        Animal animal = animalData.animalsList.get(position);

        nameTextView.setText(animal.detail);
        animalImageView.setImageResource(animal.picture);

        getSupportActionBar().setTitle(animal.name);
    }
}
