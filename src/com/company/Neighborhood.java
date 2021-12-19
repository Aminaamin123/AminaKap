package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Neighborhood {
    private ListKnapsack listKnapsack = new ListKnapsack();

    public Neighborhood(ListKnapsack listKnapsack, ListItem listItem) {
        this.listKnapsack = listKnapsack;
        boolean change = false;
        int total = totalValue(listKnapsack); // get total value of knapsack

        for (Item available : listItem.getItemList()){
            for (Knapsack knapsack : listKnapsack.getItemList()){
                if(knapsack.addItem(available)){
                    listItem.removeItem(available);
                    System.out.println("new item in list");
                    change = true;
                }
            }
        } // try filling with available
        if (change){
            int newTotal = totalValue(listKnapsack);
            System.out.println("An available item where added to the list");
            System.out.println("Old Total = "+total +" - New total = "+newTotal);
            change = false;
        }

        for (Knapsack knapsack : listKnapsack.getItemList()){
            List<Item> itemList = new ArrayList<Item>();
            itemList = knapsack.getItemList();
            for (int j = 0; j < itemList.size(); j++ ){
                Item item = itemList.get(j);
                // add items to other knapsack ???
                for (int nextKnapsack = 0; nextKnapsack < listKnapsack.getSize(); nextKnapsack++) {
                        Knapsack otherKnapsack = listKnapsack.itemByIndex(nextKnapsack);
                        if (otherKnapsack.addItem(item)) {
                            if (knapsack.removeItem(item)) {
                                change = true;
                                for (Item available : listItem.getItemList()){
                                    if(knapsack.addItem(available)){
                                        listItem.removeItem(available);
                                        System.out.println("new item in list");
                                    }
                                }
                                break;
                            }
                    }
                }
            }
        } // adding to other knapsack & and trying to fill with available
        int newTotal = totalValue(listKnapsack);
        if (change){
            System.out.println("Change has been made between knapsacks");
            change = false;
        }
        System.out.println("Old Total = "+total +" - New total = "+newTotal);

        for (Knapsack knapsack : listKnapsack.getItemList()){
            //TODO: change item in knapsack
            // remove lowest fraction
            // replace with available highest fraction if higher fraction than current
            List<Item> itemList = new ArrayList<Item>();
            itemList = knapsack.getItemList();
            float lowest = 100000;
            Item lowestItem = null;
            for (Item item : itemList){
                if(item.getFraction() < lowest){
                    lowest = item.getFraction();
                    lowestItem = item;
                }
            }
            float highest = 0;
            Item highestItem = null;
            for (Item available : listItem.getItemList()){
                if(available.getFraction() > highest){
                    highest = available.getFraction();
                    highestItem = available;
                }
            }
            if (highest > lowest){
                knapsack.removeItem(lowestItem);
                if(listItem.getSize() != 0){
                    if (knapsack.addItem(highestItem)){
                        listItem.removeItem(highestItem);
                    }else {knapsack.addItem(lowestItem);}
                }
            }

        }//Changing items to get better result

    }

    public static int totalValue(ListKnapsack listKnapsack){
        int total = 0;
        for (Knapsack knapsack : listKnapsack.getItemList()){
            total += knapsack.getValue();
        }
        return total;
    }
}
