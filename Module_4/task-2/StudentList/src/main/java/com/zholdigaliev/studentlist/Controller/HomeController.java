package com.zholdigaliev.studentlist.Controller;

import com.zholdigaliev.studentlist.DBManager.DBManager;
import com.zholdigaliev.studentlist.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getMainPage(Model model) {
        model.addAttribute("students", DBManager.getStudents());
        return "index";
    }

    @GetMapping(value = "/addStudent")
    public String getAddStudentPage() {
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent (Student student){

        DBManager.addStudent(student);

        return "redirect:/";
    }
}


