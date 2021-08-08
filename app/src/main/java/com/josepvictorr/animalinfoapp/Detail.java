package com.josepvictorr.animalinfoapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Detail implements Parcelable {

    private int animalHead;
    private int animalPic;
    private String animalName;
    private String animalHabitat;
    private String animalFood;
    private String animalAge;
    private String animalBBTB;
    private String biologyName;

    protected Detail(Parcel in){
        animalHead = in.readInt();
        animalPic = in.readInt();
        animalName = in.readString();
        animalHabitat = in.readString();
        animalFood = in.readString();
        animalAge = in.readString();
        animalBBTB = in.readString();
        biologyName = in.readString();
    }

    public Detail() {

    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };

    public String getAnimalBBTB() {
        return animalBBTB;
    }

    public void setAnimalBBTB(String animalBBTB) {
        this.animalBBTB = animalBBTB;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    public String getBiologyName() {
        return biologyName;
    }

    public void setBiologyName(String biologyName) {
        this.biologyName = biologyName;
    }

    public int getAnimalPic() {
        return animalPic;
    }

    public void setAnimalPic(int animalPic) {
        this.animalPic = animalPic;
    }

    public int getAnimalHead() {
        return animalHead;
    }

    public void setAnimalHead(int animalHead) {
        this.animalHead = animalHead;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalHabitat() {
        return animalHabitat;
    }

    public void setAnimalHabitat(String animalHabitat) {
        this.animalHabitat = animalHabitat;
    }

    public String getAnimalFood() {
        return animalFood;
    }

    public void setAnimalFood(String animalFood) {
        this.animalFood = animalFood;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(animalHead);
        parcel.writeInt(animalPic);
        parcel.writeString(animalName);
        parcel.writeString(animalHabitat);
        parcel.writeString(animalFood);
        parcel.writeString(animalAge);
        parcel.writeString(animalBBTB);
        parcel.writeString(biologyName);
    }
}
