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
    private List<Item> itemPath = new ArrayList<Item>();
    ListItem listItem = new ListItem();
    private int max = 10;

    public Greedy() {
        setItems();
        algorithm();
    }

    public void setItems(){
        for (int i = 0; i < 4; i++) {
            Random rn = new Random();
            Item item = new Item(1+rn.nextInt(10), 1+rn.nextInt(10), i);
            listItem.addItemList(item);
        }
        for (Item item : listItem.getItemList()) {
            System.out.print("V");
            System.out.print(item.getValue());
            System.out.print("W");
            System.out.print(item.getWeight());
            System.out.print("---");
        }
    }

    public void algorithm(){
        int sumWeight = 0;
        int sumProfit = 0;
        boolean done = false;
        while (!done){
            Item item = getMaxFraction();
            done = true;
            int temp = sumWeight + item.getWeight();
            if(temp <= max){
               done = false;
               sumWeight = temp;
               itemPath.add(item);
               sumProfit = sumProfit + item.getValue();
            }
        }
        String output ="Sum value:" + sumWeight + "Sum weight:" + sumWeight;
        System.out.println(output);
    }

    public Item getMaxFraction(){
        float maxFraction = 0;
        Item bestFraction = null;
        for (int i = 0; i < listItem.getSize(); i++){
            Item temp = listItem.itemByIndex(i);
            if (temp.getFraction() > maxFraction){
                maxFraction = temp.getFraction();
                bestFraction = temp;
            }
        }
        return bestFraction;
    }


}
