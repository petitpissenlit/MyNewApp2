package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList= new ArrayList<>();
    String[] fruitList = new String[]{"PurpleHaze", "Cannalope Haze" , "MangoKush", "MangoHaze", "PineappleHaze","LemonHaze"
    ,"GuavaHaze" , "Amnezia" , "SilverHaze" , "Wedding Cake"};

    String[] fruitNum= new String[]{" H1" ," H2", "H3", " H4"," H5","H6"
            ,"H7","H8","H9","H10" };

    int[] imgList= new int[]{R.drawable.r,R.drawable.canaloppe, R.drawable.mangokush, R.drawable.mango, R.drawable.pineapple, R.drawable.lemonhaze,
            R.drawable.guava , R.drawable.amnesia_11zon , R.drawable.silverhaze , R.drawable.weddingcake_11zon};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recyclerView=findViewById(R.id.recylerView);
        searchView=findViewById(R.id.searchView);

        for (int i = 0; i<fruitList.length; i++){
            ModelClass modelClass = new ModelClass();
            modelClass.setFruitName(fruitList[i]);
            modelClass.setFruitName(fruitNum[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }
    }


}