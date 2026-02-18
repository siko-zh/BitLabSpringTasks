package com.zholdigaliev.electronicshopitems.db;

import com.zholdigaliev.electronicshopitems.model.Item;

import java.util.ArrayList;


public class dbManager {
    private static ArrayList<Item> electronics = new ArrayList<>();

    static {
        electronics.add(new Item(1L, "Mac Book Pro", "8 GB RAM 256 GB SSD Intel Core i7", 1199.99));
        electronics.add(new Item(1L, "Mac Book Pro", "16 GB RAM 500 GB SSD Apple M1", 1499.99));
        electronics.add(new Item(1L, "Mac Book Pro", "16 GB RAM 1 TB SSD Apple M1", 1799.99));
        electronics.add(new Item(1L, "ASUS Tuf Gaming", "16 GB RAM 500 GB SSD Intel Core i7", 1299.99));
        electronics.add(new Item(1L, "HP ProBook", "8 GB RAM 500 GB SSD Intel Core i5", 999.99));
        electronics.add(new Item(1L, "Lenovo Legion", "32 GB RAM 512 GB SSD Intel Core i7", 1399.99));
    }

    public static ArrayList<Item> getItems() {
        return electronics;
    }
}
