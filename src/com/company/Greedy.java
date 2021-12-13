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
            System.out.print(" W");
            System.out.println(item.getWeight());
        }
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
                System.out.print(max);
                System.out.print(" - ");
                System.out.print(sumWeight);
                System.out.print(" - ");
                System.out.print(temp);
                System.out.print(" - ");
                System.out.println(item.getWeight());
                if (temp <= max) {
                    done = false;
                    sumWeight = temp;
                    itemPath.add(item);
                    sumProfit = sumProfit + item.getValue();
                }}else{done = true;}
                listItem.removeItem(item);
            //}
        }
        String output ="Sum value:" + sumProfit + " - Sum weight:" + sumWeight;
        System.out.println(output);
        System.out.println("The knapsack contains:");
        for (Item print : itemPath)    {
              String out ="Value:" + print.getValue() + " - Weight:" + print.getWeight();
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
