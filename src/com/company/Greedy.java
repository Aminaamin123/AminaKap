package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Greedy {
    /*
    * check value / weight
    * Compare to choose items
    * Check weight capacity if full ? are there smaller weights that do fit?
    * */
    final double[] knapsacks = {100, 100, 100, 100, 100};

    int currentWeight = 0;
    final int maxLevel = 20;
    int depth = 3;
    private List<Item> knapsackItems = new ArrayList<Item>();
    ListItem listItem = new ListItem();


    public Greedy() {
        System.out.println("Greedy algorithm tree search - find optimal path, locally");
        setItems(); // setting some test items to tree and prints the tree
        System.out.println("       ----------------------------------------");
        knapsack();
        System.out.println("The items in the knapsack");
        for (Item item : knapsackItems){
            System.out.print("Value: ");
            System.out.print(item.getValue());
            System.out.print(" Weight: ");
            System.out.print(item.getWeight());
            System.out.println("");
        }System.out.println("");
    }

    public void knapsack(){
        while (currentWeight < maxLevel) {
            knapsackItems.add(findBestItem());
            currentWeight += findBestItem().getWeight();
        }

    }

    public Item findBestItem() {
        float max = 0;
        int nr = 0;
        Item highest = null;

        for (Item item : listItem.getItemList()){
            float count = item.getValueWeight();
            if (count > max) {
                max = count;
                highest = item;
            }
        }
        return highest;
    }

    public void setItems(){
        for (int i = 0; i < 14; i++) {
            Random rn = new Random();
            Item secondItem = new Item(1 + rn.nextInt(20), 1 + rn.nextInt(20), i);
            listItem.addItemList(secondItem);
        }
    }





}
