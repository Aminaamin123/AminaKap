package com.company;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * 1 Greedy Algorithm to create Multiple Knapsacks
        * 2 Improve Search with Neighborhood Search
        */
        ListKnapsack listKnapsack = new ListKnapsack();
        Random rn = new Random();
        ListItem listItem = new ListItem();
        Scanner myObj = new Scanner(System.in);

        //System.out.println(listItem.getItemList());
        System.out.println("Enter amount of knapsacks");
        int amountOfKnapsacks = myObj.nextInt();

        for (int i = 0; i < 30*amountOfKnapsacks; i++) { // set all items
            Item item = new Item(1+rn.nextInt(10), 1+rn.nextInt(10), i);
            listItem.addItem(item);
        }

        for (int i = 1; i <= amountOfKnapsacks; i++) {
            Greedy greedy = new Greedy(10 + rn.nextInt(11), listItem);
            Knapsack knapsack = greedy.start();
            listKnapsack.addItemList(knapsack);
            listItem = greedy.getUnusedItem();
        }

        // Adding Neighborhood Search to improve
        //TODO: send list of knapsacks into Neighborhood to improve search
        Neighborhood neighborhood = new Neighborhood(listKnapsack, listItem);
    }

}
