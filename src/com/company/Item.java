package com.company;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private long itemId;
    private int weight;
    private int value;
    private List<Item> children = new ArrayList<Item>();

    public Item(int weight, int value, long itemId) {
        this.weight = weight;
        this.value = value;
        this.itemId = itemId;
    }
    public List<Item> getChildren(){
        if(children.isEmpty()) {
        return null;
        }
        return children;
    }

    public int getWeight(){
        return weight;
    }

    public int getValue(){
        return value;
    }
    public long getItemId(){
        return itemId;
    }

    public void addChild(Item item){
        children.add(item);
    }



}