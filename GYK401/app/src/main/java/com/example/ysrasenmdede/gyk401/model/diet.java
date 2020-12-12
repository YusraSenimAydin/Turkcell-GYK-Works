package com.example.ysrasenmdede.gyk401.model;

public class diet {
    int FoodPicture;
    String FoodName;
    String FoodCalorie;


    public diet(int FoodPicture , String FoodName , String FoodCalorie){
        this.FoodPicture=FoodPicture;
        this.FoodName=FoodName;
        this.FoodCalorie=FoodCalorie;

    }

    public int getFoodPicture() {
        return FoodPicture;
    }

    public String getFoodName() {
        return FoodName;
    }

    public String getFoodCalorie() {
        return FoodCalorie;
    }

    public void setFoodPicture(int foodPicture) {
        FoodPicture = foodPicture;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public void setFoodCalorie(String foodCalorie) {
        FoodCalorie = foodCalorie;
    }
}
