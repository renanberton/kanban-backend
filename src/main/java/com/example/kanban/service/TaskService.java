package com.example.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kanban.model.Status;
import com.example.kanban.model.Task;
import com.example.kanban.tarefaRepository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public List<Task> listarPorStatus(Status status) {
        return taskRepository.findByStatus(status);
    }

    public Task criarTarefa(Task task) {
    	task.setStatus(task.getStatus()); 
        return taskRepository.save(task);
    }

    public Task atualizarTarefa(Long id, Task novaTarefa) {
        return taskRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTitulo(novaTarefa.getTitulo());
                    tarefa.setDescricao(novaTarefa.getDescricao());
                    tarefa.setStatus(novaTarefa.getStatus());
                    return taskRepository.save(tarefa);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public void deletarTarefa(Long id) {
        taskRepository.deleteById(id);
    }
}