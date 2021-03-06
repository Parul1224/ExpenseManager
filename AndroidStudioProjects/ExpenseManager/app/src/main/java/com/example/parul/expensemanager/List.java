package com.example.parul.expensemanager;

public class List {
    private String item;
    private String UniqueId;
    private String day;
    private int quan;
    private int price;

    public List(String item, String uniqueId,String day, int quan, int price) {
        this.item = item;
        this.UniqueId = uniqueId;
        this.quan = quan;
        this.day=day;
        this.price = price;
    }

    public List() {

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUniqueId() {
        return UniqueId;
    }

    public void setUniqueId(String uniqueId) {
        UniqueId = uniqueId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
