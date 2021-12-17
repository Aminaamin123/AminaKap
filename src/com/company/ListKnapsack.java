package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListKnapsack {
    private List<Knapsack> Knapsacks = new ArrayList<Knapsack>();

    public List<Knapsack> getItemList() {
        return Knapsacks;
    }
    public void addItemList(Knapsack knapsack) {
        Knapsacks.add(knapsack);
    }
    public void removeItem(Knapsack knapsack) {
        Knapsacks.remove(knapsack);
    }
    public Knapsack firstInItemList() {
        return Knapsacks.get(0);
    }
    public Knapsack itemByIndex(int index) {
        return Knapsacks.get(index);
    }
    public int getSize() {
        return Knapsacks.size();
    }
}
