package com.zholdigaliev.electronicshopitems.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    Long id;
    String name;
    String description;
    double price;
}

