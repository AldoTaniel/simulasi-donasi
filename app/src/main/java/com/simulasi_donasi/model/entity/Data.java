package com.simulasi_donasi.model.entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Macdoze on 28-May-17.
 */

public class Data {
    private int id;
    private int img;
    private String name;
    private String bio;
    private int amount;

    public static int _id = 1;

    public static ArrayList<Data> datas = new ArrayList<>();

    public Data() {}

    public Data(String name, String bio, int amount) {
        this.name = name;
        this.amount = amount;
        this.bio = bio;
        this.id = _id;
        _id++;
    }

    public int getId() {
        return id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }

}
