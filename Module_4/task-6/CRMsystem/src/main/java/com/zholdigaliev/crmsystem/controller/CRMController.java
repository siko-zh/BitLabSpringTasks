package com.zholdigaliev.crmsystem.controller;

import com.zholdigaliev.crmsystem.db.DBConnector;
import com.zholdigaliev.crmsystem.entity.ApplicationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CRMController {

    @GetMapping(value = "/")
    public String getHome(Model model) {
        model.addAttribute("requests", DBConnector.getAllRequests());
        return "index";
    }

    @GetMapping("/add-request")
    public String getAddPage(Model model) {
        model.addAttribute("courses", DBConnector.getAllCourses());
        return "add-request";
    }

    @GetMapping("/details/{id}")
    public String getRequestInfo(@PathVariable int id,
                                 Model model) {
        model.addAttribute("request", DBConnector.getRequestById(id));
        return "details";
    }

    @GetMapping("/new-requests")
    public String getNewRequests (Model model){
        model.addAttribute("requests", DBConnector.getNewRequests());
        return "index";
    }

    @GetMapping("/processed-requests")
    public String getProcessedRequests (Model model){
        model.addAttribute("requests", DBConnector.getProcessedRequests());
        return "index";
    }

    @PostMapping(value = "/add-request")
    public String addRequest(ApplicationRequest request) {
        DBConnector.addRequest(request);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateRequest(@RequestParam int id, @RequestParam Boolean handled) {
        DBConnector.updateRequest(id, handled);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteRequest(int id) {
        DBConnector.deleteRequest(id);
        return "redirect:/";
    }



}
