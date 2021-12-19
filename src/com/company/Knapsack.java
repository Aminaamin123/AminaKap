package com.company;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private List<Item> itemList = new ArrayList<Item>();
    //private List<Item> avalibleItem = new ArrayList<Item>();
    private int capacity;

    public Knapsack(int capacity, List<Item> itemList){
        this.capacity = capacity;
        this.itemList = itemList;
    }

    public int getWeight(){
        int weight = 0;
        for (Item item : itemList){
            weight += item.getWeight();
        }
        return weight;
    }

    public int getValue() {
        int value = 0;
        for (Item item: itemList) {
            value += item.getValue();
        }
        return value;
    }

    public int getSpaceInKnapsack() {
        return capacity - getWeight();
    }

    public boolean addItem(Item item) {
        int weight = getWeight() + item.getWeight();
        if( weight <= capacity){
            itemList.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        for (Item exists : itemList) {
            if (exists == item) {
                itemList.remove(item);
                return true;
            }
        }
        return false;
    }
    public List<Item> getItemList() {
        return itemList;
    }
    public int getCapacity(){
        return capacity;
    }
    public Item firstInItemList() {return itemList.get(0);}
    public Item itemByIndex(int index) {return itemList.get(index);}
    public int getSize() {return itemList.size();}

}
