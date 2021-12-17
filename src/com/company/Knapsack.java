package com.company;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private List<Item> itemList = new ArrayList<Item>();
    private List<Item> avalibleItem = new ArrayList<Item>();
    private int capacity;

    public Knapsack(int capacity, List<Item> itemList, List<Item> avalibleItem){
        this.capacity = capacity;
        this.itemList = itemList;
        this.avalibleItem = avalibleItem;
    }

    public void setAvalibleItem(List<Item> list) {
        avalibleItem = list;
    }


    public void addItem(Item item) {
        itemList.add(item);
    }
    public void reomveItem(Item item) {
        itemList.remove(item);
    }
    public List<Item> getItemList() {
            return itemList;
    }

    public int getWeight(){
        int weight = 0;
        for (Item item : itemList){
            weight += item.getWeight();
        }
        return weight;
    }
    public int getCapacity(){
        return capacity;
    }

    public Item firstInItemList() {
        return itemList.get(0);
    }
    public Item itemByIndex(int index) {
        return itemList.get(index);
    }
    public int getSize() {
        return itemList.size();
    }

}
