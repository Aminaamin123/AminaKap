package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Neighborhood {
    private ListKnapsack listKnapsack = new ListKnapsack();

    public Neighborhood(ListKnapsack listKnapsack) {
        this.listKnapsack = listKnapsack;
        for (Knapsack knapsack : listKnapsack.getItemList()){
            //System.out.println(knapsack.getItemList());
            List<Item> children = new ArrayList<Item>();
            children = knapsack.getItemList();
            //System.out.println(children.get(0).getWeight());
            //System.out.println(children.size());
        }
    }
}
