package com.josepvictorr.animalinfoapp;

import java.io.Serializable;

public class Animal implements Serializable {
    private int animalHead;
    private int animalPic;
    private String animalName;
    private String animalHabitat;
    private String animalFood;
    private String animalAge;
    private String animalBBTB;
    private String biologyName;


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
}
