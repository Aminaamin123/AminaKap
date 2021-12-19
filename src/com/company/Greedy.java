package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Greedy {
    /* check value / weight
    *  Compare to choose items on each step - local
    */
    private List<Item> itemPath = new ArrayList<Item>();
    ListItem listItem = new ListItem();
    //private List<Item> avalibleItem = new ArrayList<Item>();
    ListItem avalibleItem = new ListItem();
    private int max;
    Knapsack knapsack;

    public Greedy(int max, ListItem avalible) {
        this.max = max;
        this.avalibleItem = avalible;
        this.listItem = avalible;
        /*
        setItems();
        algorithm();
        return knapsack;
        */
    }

    public Knapsack start() {
        //setItems(); //TODO: make a user interface to set items - RegisterItems();
        algorithm();
        return knapsack;
    }
    public ListItem getUnusedItem() {
        for (Item used: itemPath){
            avalibleItem.removeItem(used);
        }
        return avalibleItem;
    }

    public void algorithm(){
        int sumWeight = 0;
        int sumProfit = 0;
        boolean done = false;
        while (!done){
            Item item = getMaxFraction();
            if (getMaxFraction() != null) {
                done = true;
                int temp = sumWeight + item.getWeight();
                if (temp <= max) {
                    done = false;
                    sumWeight = temp;
                    itemPath.add(item);
                    sumProfit = sumProfit + item.getValue();
                }else{
                    for (Item loop : listItem.getItemList())
                    if (item.getWeight() > loop.getWeight()){
                        done = false;
                    }
                }
            }else{done = true;}
            listItem.removeItem(item);
        }
        knapsack = new Knapsack(max, itemPath, avalibleItem);
        // print(sumProfit, sumWeight);
    }

    public void print(int profit, int weight){
        String output ="Sum value: " + profit + " - Sum weight: " + weight;
        System.out.println(output);
        System.out.println("The knapsack contains:");
        for (Item print : itemPath)    {
            String out ="Value: " + print.getValue() + " - Weight: " + print.getWeight();
            System.out.println(out);
        }
    }

    public Item getMaxFraction(){
        float maxFraction = 0;
        Item bestFraction = null;
        for (Item temp : listItem.getItemList()){
            if (temp.getFraction() >= maxFraction){
                maxFraction = temp.getFraction();
                bestFraction = temp;
            }
        }
        return bestFraction;
    }


}
