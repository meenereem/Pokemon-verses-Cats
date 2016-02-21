package com.example.meenereem.searchforfun;



public class Card{
   private String str;
   private int pointVal;
    public Card(String str, int pointVal){
        this.str = str;
        this.pointVal = pointVal;
    }
    public String getString(){
        return str;
    }
    public int getPointVal(){
        return pointVal;
    }


}
