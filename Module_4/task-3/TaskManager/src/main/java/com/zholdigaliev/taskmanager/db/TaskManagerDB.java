package com.zholdigaliev.taskmanager.db;

import com.zholdigaliev.taskmanager.Model.Task;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;


public class TaskManagerDB {
    private static int idCount = 4;
    @Getter
    private static ArrayList<Task> taskArrayList = new ArrayList<>();

    static {
        taskArrayList.add(new Task(1, "fkldsjf", "dfsdfsdfsd",LocalDate.now().plusDays(7), false));
        taskArrayList.add(new Task(2, "fkldsjf", "dfsdfsdfsd",LocalDate.now().plusDays(7), false));
        taskArrayList.add(new Task(3, "fkldsjf", "dfsdfsdfsd",LocalDate.now().plusDays(7), false));
    }

    public static void createTask(Task task) {
        task.setId(idCount);
        idCount++;
        taskArrayList.add(task);
    }

    public static Task getTaskById(int id) {
        return taskArrayList.stream().filter(task -> task.getId()==id).findFirst().get();
    }


    public static void deleteById(int id) {
        taskArrayList.removeIf(task -> task.getId()==id);
    }

    public static void updateTask(Task task) {
        for (Task t : taskArrayList) {
            if(t.getId() == task.getId()) {
                t.setName(task.getName());
                t.setDescription(task.getDescription());
                t.setDeadline(task.getDeadline());
                t.setIsCompleted(task.getIsCompleted());
            }
        }
    }
}
