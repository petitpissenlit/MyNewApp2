package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList= new ArrayList<>();
    ArrayList<ModelClass> searchList;
    String[] fruitList = new String[]{"PurpleHaze", "Cannalope Haze" , "MangoKush", "MangoHaze", "PineappleHaze","LemonHaze"
            ,"GuavaHaze" , "Amnezia" , "SilverHaze" , "Wedding Cake"};

    String[] fruitNum= new String[]{ "PurpleHaze", "Cannalope Haze" , "MangoKush", "MangoHaze", "PineappleHaze","LemonHaze"
            ,"GuavaHaze" , "Amnezia" , "SilverHaze" , "Wedding Cake"};

    int[] imgList= new int[]{R.drawable.r,R.drawable.canaloppe, R.drawable.mangokush, R.drawable.mango, R.drawable.pineapple, R.drawable.lemonhaze,
            R.drawable.guava , R.drawable.amnesia_11zon , R.drawable.silverhaze , R.drawable.weddingcake_11zon};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        recyclerView=findViewById(R.id.recylerView);
        searchView=findViewById(R.id.searchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        for (int i = 0; i<fruitList.length; i++){
            ModelClass modelClass = new ModelClass();
            modelClass.setFruitName(fruitList[i]);
            modelClass.setFruitName(fruitNum[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProfileActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter fruitAdapter =new FruitAdapter(ProfileActivity.this,arrayList);
        recyclerView.setAdapter(fruitAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList=new ArrayList<>();

                if (query.length()>0){
                    for (int i = 0; i < arrayList.size() ; i++) {
                        if(arrayList.get(i).getFruitName().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getFruitNum().toUpperCase().contains(query.toUpperCase())){

                            ModelClass modelClass= new ModelClass();
                            modelClass.setFruitName(arrayList.get(i).getFruitName());
                            modelClass.setFruitNum(arrayList.get(i).getFruitNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);


                        }




                    }
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProfileActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter =new FruitAdapter(ProfileActivity.this,searchList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProfileActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter =new FruitAdapter(ProfileActivity.this,arrayList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList=new ArrayList<>();

                if (newText.length()>0){
                    for (int i = 0; i < arrayList.size() ; i++) {
                        if(arrayList.get(i).getFruitName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getFruitNum().toUpperCase().contains(newText.toUpperCase())){

                            ModelClass modelClass= new ModelClass();
                            modelClass.setFruitName(arrayList.get(i).getFruitName());
                            modelClass.setFruitNum(arrayList.get(i).getFruitNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);


                        }




                    }
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProfileActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter =new FruitAdapter(ProfileActivity.this,searchList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProfileActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    FruitAdapter fruitAdapter =new FruitAdapter(ProfileActivity.this,arrayList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                return false;
            }
        });
    }


}