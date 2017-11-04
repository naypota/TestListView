package com.example.user.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.testlistview.Model.Animal;
import com.example.user.testlistview.adapter.AnimalListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.List_View);

        final AnimalData animalData = AnimalData.getInstance();
        animalData.animalsList = new ArrayList<>();

        animalData.animalsList.add(new Animal("แมว (Cat)", R.drawable.cat,R.string.details_cat));
        animalData.animalsList.add(new Animal("หมา (Dog)", R.drawable.dog,R.string.details_dog));
        animalData.animalsList.add(new Animal("โลมา (Dolphin)", R.drawable.dolphin,R.string.details_dolphin));
        animalData.animalsList.add(new Animal("โคอาลา (Koala)", R.drawable.koala,R.string.details_koala));
        animalData.animalsList.add(new Animal("นกฮูก (Owl)", R.drawable.owl,R.string.details_owl));
        animalData.animalsList.add(new Animal("กระต่าย (Ribbit)", R.drawable.rabbit,R.string.details_rabbit));
        animalData.animalsList.add(new Animal("เพนกวิ้น (Penguin)", R.drawable.penguin,R.string.details_penguin));
        animalData.animalsList.add(new Animal("เสือ (Tiger)", R.drawable.tiger,R.string.details_tiger));
        animalData.animalsList.add(new Animal("หมู (Pig)", R.drawable.pig,R.string.details_pig));
        animalData.animalsList.add(new Animal("สิงโต (Lion)", R.drawable.lion,R.string.details_lion));

        AnimalListAdapter adapter = new AnimalListAdapter(
                this,
                R.layout.item,
                animalData.animalsList
        );

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = animalData.animalsList.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnimalDetial.class);
                //intent.putExtra("name", animal.name);
                //intent.putExtra("picture", animal.picture);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
    }
}
