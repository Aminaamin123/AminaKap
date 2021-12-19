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

        for (int i = 0; i < listKnapsack.getSize(); i++){
            Knapsack knapsack = listKnapsack.itemByIndex(i);
            List<Item> itemList = new ArrayList<Item>();
            itemList = knapsack.getItemList();
            for (int j = 0; j < itemList.size(); j++ ){
                Item item = itemList.get(j);
                // add items to other knapsack ???
                for (int nextKnapsack = 0; nextKnapsack < listKnapsack.getSize(); nextKnapsack++) {
                    if (nextKnapsack == i) {
                        continue;
                    }
                    else{
                        Knapsack otherKnapsack = listKnapsack.itemByIndex(nextKnapsack);
                        if (otherKnapsack.addItem(item)) {
                            if (knapsack.removeItem(item)) {
                                change = true;
                                System.out.println("CHANGE HAPPENING");
                                break;
                            }
                        }
                    }
                }
            }
        } // adding to other sack
        int newTotal = totalValue(listKnapsack);

        System.out.println("Old Total = "+total +" - New total = "+newTotal);


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
