package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListItem {
    private List<Item> itemList = new ArrayList<Item>();

    public List<Item> getItemList() {
        return itemList;
    }
    public void addItemList(Item item) {
        itemList.add(item);
    }
    public Item firstInItemList() {
        return itemList.get(0);
    }
}
