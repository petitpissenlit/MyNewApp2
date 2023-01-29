package com.example.mynewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyHolder>{

    Context context;
    ArrayList<ModelClass> arrayList;
    LayoutInflater layoutInflater;

    public FruitAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item, parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
    holder.fruitName.setText(arrayList.get(position).getFruitName());
    holder.fruitNum.setText(arrayList.get(position).getFruitNum());
    holder.img.setImageResource(arrayList.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView fruitName,fruitNum;
        ImageView img;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            fruitName=itemView.findViewById(R.id.txt);
            fruitNum=itemView.findViewById(R.id.txt2);
            img=itemView.findViewById(R.id.img);
        }
    }
        }


