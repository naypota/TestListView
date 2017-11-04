package com.example.user.testlistview;

import com.example.user.testlistview.Model.Animal;

import java.util.ArrayList;

/**
 * Created by user on 29/10/2560.
 */

public class AnimalData {
    private static AnimalData sInstance;
    public ArrayList<Animal> animalsList;

    public static AnimalData getInstance(){
        if(sInstance == null){
            sInstance = new AnimalData();
        }
        return sInstance;
    }
}
