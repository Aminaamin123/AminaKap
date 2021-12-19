package com.company;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private List<Item> itemList = new ArrayList<Item>();
    //private List<Item> avalibleItem = new ArrayList<Item>();
    ListItem avalibleItem = new ListItem();
    private int capacity;

    public Knapsack(int capacity, List<Item> itemList, ListItem avalibleItem){
        this.capacity = capacity;
        this.itemList = itemList;
        this.avalibleItem = avalibleItem;
    }

    public int getWeight(){
        int weight = 0;
        for (Item item : itemList){
            weight += item.getWeight();
        }
        return weight;
    }

    public void setAvalibleItem(ListItem list) {avalibleItem = list;}
    public ListItem getAvalibleItem() {
        return avalibleItem;
    }
    public void addItem(Item item) {itemList.add(item);}
    public void reomveItem(Item item) {itemList.remove(item);}
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
