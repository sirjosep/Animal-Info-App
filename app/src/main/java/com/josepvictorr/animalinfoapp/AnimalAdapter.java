package com.josepvictorr.animalinfoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnimalAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<Animal> animals = new ArrayList<>();

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public AnimalAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int i) {
        return animals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_animal, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        Animal animal = (Animal) getItem(i);
        viewHolder.bind(animal);
        return itemView;
    }

    public class ViewHolder{
        public ImageView imgAnimalHead;
        public TextView tvAnimalName;

        ViewHolder(View view){
            imgAnimalHead = view.findViewById(R.id.animal_head);
            tvAnimalName = view.findViewById(R.id.animal_name);
        }

        void bind(Animal animal){
            imgAnimalHead.setImageResource(animal.getAnimalHead());
            tvAnimalName.setText(animal.getAnimalName());
        }
    }
}
