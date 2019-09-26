package com.example.myapplication;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyViewModel extends ViewModel {

    MutableLiveData<List<String>> fruitList ;

    public LiveData<List<String>> getFruitList(){
        if(fruitList==null){
            fruitList = new MutableLiveData<>();
            loadFruitList();
        }
        return fruitList;
    }

    private void loadFruitList(){
        Handler mHandler = new Handler();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                List<String> fruitsStringList = new ArrayList<>();
                fruitsStringList.add("Mango");
                fruitsStringList.add("Apple");
                fruitsStringList.add("Bannana");
                fruitsStringList.add("Orange");
                fruitsStringList.add("Strawabre");
                Long seed = System.nanoTime();
                Collections.shuffle(fruitsStringList, new Random(seed));
                fruitList.setValue(fruitsStringList);
            }
        };
        mHandler.postDelayed(r,5000);
    }
}
