package ru.hse.edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer {
    private String vis_name;
    private ArrayList<Integer> dish;

    public ArrayList<Integer> getDish() {
        return dish;
    }
    public String getVis_name() {
        return vis_name;
    }

    public Customer(String vis_name) {
        this.vis_name = vis_name;
        dish = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dish.add((int)(Math.random()*17));
        }
    }

    @Override
    public String toString() {
        String out = vis_name.concat("\n");
        for (Integer elem: dish) {
            out = out.concat(elem.toString().concat("\n"));
        }
        return out;
    }

    public int getColor() {
        return 0;
    }
}
