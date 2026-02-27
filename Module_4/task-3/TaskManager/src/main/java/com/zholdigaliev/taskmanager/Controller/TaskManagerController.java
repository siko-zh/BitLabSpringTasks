package com.zholdigaliev.taskmanager.Controller;

import com.zholdigaliev.taskmanager.Model.Task;
import com.zholdigaliev.taskmanager.db.TaskManagerDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskManagerController {

    @GetMapping("/")
    public String getAllTasks(Model model){
        model.addAttribute("tasks", TaskManagerDB.getTaskArrayList());
        return "index";
    }

    @PostMapping("/add-task")
    public String createTask(Task task) {
        TaskManagerDB.createTask(task);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String getTask(
            @PathVariable
            int id,
            Model model) {
        model.addAttribute("task", TaskManagerDB.getTaskById(id));
        return "details";
    }

    @PostMapping("/update")
    public String updateTask(
            Task task
    ) {
        TaskManagerDB.updateTask(task);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTask(
            @RequestParam
            int id
    ) {
            TaskManagerDB.deleteById(id);
            return "redirect:/";
    }


}
