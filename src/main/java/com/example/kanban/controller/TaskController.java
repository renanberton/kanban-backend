package com.example.kanban.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.kanban.model.Task;
import com.example.kanban.model.Status;
import com.example.kanban.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TaskController {
    @Autowired
    private TaskService tarefaService;
    
    @CrossOrigin(origins = "http://localhost:5173") 
    @GetMapping("/api/tarefas")
    public List<Task> getTarefas() {
        return tarefaService.listarTodas();
    }

    @GetMapping
    public List<Task> listarTodas() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/status/{status}")
    public List<Task> listarPorStatus(@PathVariable Status status) {
        return tarefaService.listarPorStatus(status);
    }

    @PostMapping
    public Task criarTarefa(@RequestBody Task tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Task atualizarTarefa(@PathVariable Long id, @RequestBody Task tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }
}
