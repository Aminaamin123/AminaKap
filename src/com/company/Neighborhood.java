package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Neighborhood {
    private ListKnapsack listKnapsack = new ListKnapsack();

    public Neighborhood(ListKnapsack listKnapsack, ListItem listItem) {
        this.listKnapsack = listKnapsack;
        int total = totalValue(listKnapsack); // get total value of knapsack
        boolean change = false;
        //ListKnapsack copy = listKnapsack;

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
        } // adding to other sack & and trying to fill with available

        if (change){
            int newTotal = totalValue(listKnapsack);
            System.out.println("Change has been made between knapsacks");
            System.out.println("Old Total = "+total +" - New total = "+newTotal);
            change = false;
        }

        for (Knapsack knapsack : listKnapsack.getItemList()){
            //System.out.println(knapsack.getItemList());
            List<Item> itemList = new ArrayList<Item>();
            itemList = knapsack.getItemList();

            if (knapsack.getSpaceInKnapsack() > 0){

            }

            //System.out.println(children.get(0).getWeight());
            //System.out.println(children.size());
        }
    }

    public static int totalValue(ListKnapsack listKnapsack){
        int total = 0;
        for (Knapsack knapsack : listKnapsack.getItemList()){
            total += knapsack.getValue();
        }
        return total;
    }
}
