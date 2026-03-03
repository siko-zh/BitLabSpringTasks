package com.zholdigaliev.crmsystem.controller;

import com.zholdigaliev.crmsystem.db.DBConnector;
import com.zholdigaliev.crmsystem.entity.ApplicationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CRMController {
    ArrayList<String> courses = new ArrayList<>(List.of("Java Developer", "Advanced Java Developer", "Go Developer",
            "UX/UI Дизайн"));
    @GetMapping(value = "/")
    public String getHome(Model model) {
        model.addAttribute("requests", DBConnector.getAllRequests());
        return "index";
    }

    @GetMapping("/add-request")
    public String getAddPage(Model model) {
        model.addAttribute("courses", courses);
        return "/add-request";
    }

    @PostMapping(value = "/add-request")
    public String addRequest(ApplicationRequest request) {
        DBConnector.addRequest(request);
        return "redirect:/";
    }

}
