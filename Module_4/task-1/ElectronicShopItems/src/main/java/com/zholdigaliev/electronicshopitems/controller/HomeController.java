package com.zholdigaliev.electronicshopitems.controller;

import com.zholdigaliev.electronicshopitems.db.dbManager;
import com.zholdigaliev.electronicshopitems.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getMainPage(Model item){
        item.addAttribute("items", dbManager.getItems());
        return "index";
    }
}
