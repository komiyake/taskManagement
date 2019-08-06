package com.example.demo.web;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Task> list = service.getAllTasks();
        model.addAttribute("tasklist", list);

        return "home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createTask(@ModelAttribute Task task) {
        service.save(task);

        return "complete";
    }


    @ModelAttribute
    Task setupTask() {
        return new Task();
    }

}
