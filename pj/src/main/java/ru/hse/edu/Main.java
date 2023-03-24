package ru.hse.edu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        User evpat = new User();
        while (true) {
            System.out.println("Введите create для создания нового клиента.");
            System.out.println("Введите serialize для скачивания через пробел для того, чтобы скачать файл.");
            System.out.println("Введите deserialize для того, чтобы завершить работу приложения.");
            System.out.println("Введите show, чтобы вывести внутренности Евпата в консоль...");
            System.out.println("Введите exit для того, чтобы завершить работу приложения.");
            String input = in.nextLine();
            switch (input) {
                case "create" :
                    System.out.println("Введите имя нового клиента.");
                    input = in.nextLine();
                    evpat.addCustomer(input);
                    break;
                case "serialize" :
                    Gson gson = new GsonBuilder()
                            .setPrettyPrinting()
                            .create();
                    String json = gson.toJson(evpat);
                    System.out.println("Введите путь к файлу из которого вы хотите произвести десериализацию");
                    String inStrFilePath = in.nextLine();
                    Path inFilePath = Paths.get(inStrFilePath);
                    try {
                        Files.createFile(inFilePath);
                        Files.writeString(inFilePath, json);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "deserialize":
                    System.out.println("Введите путь к файлу из которого вы хотите произвести десериализацию");
                    String outStrFilePath = in.nextLine();
                    Path outFilePath = Paths.get(outStrFilePath);
                    String jsonIn;
                    try {
                        jsonIn = Files.readString(outFilePath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    evpat = new Gson().fromJson(jsonIn, User.class);
                    break;
                case "show":
                    evpat.print();
                    break;
                case "exit":
                    return;
            }
        }
    }
}