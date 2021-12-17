package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        * 1 Greedy Algorithm to create Multiple Knapsacks
        * 2 Improve Search with Neighborhood Search
        */

        ListKnapsack listKnapsack = new ListKnapsack();
        int amountOfKnapsacks = 5;
        for (int i = 1; i <= amountOfKnapsacks; i++) {
            Greedy greedy = new Greedy();
            Knapsack knapsack = greedy.start();
            listKnapsack.addItemList(knapsack);
        }

        // Adding Neighborhood Search to improve
        //TODO: send list of knapsacks into Neighborhood to improve search
        Neighborhood neighborhood = new Neighborhood(listKnapsack);

    }

}
