package ru.hse.edu;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class User {
    private Collection<Customer> skills;

    public Collection<Customer> getSkills() {
        return skills;
    }

    public User() {
        this.skills = new ArrayList<>();
    }


    void addCustomer(String name) {
        Customer newCustomer = new Customer(name);
        skills.add(newCustomer);
    }

    void print() {
        for (Customer element: skills) {
            System.out.println(element);
        }
    }
}
