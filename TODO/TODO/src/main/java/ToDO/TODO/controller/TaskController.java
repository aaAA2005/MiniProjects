package ToDO.TODO.controller;


import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ToDO.TODO.entity.TaskEntity;

import ToDO.TODO.service.Taskservice;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {
	
	
	private Taskservice service;
	
	public TaskController(Taskservice service) {
		this.service=service;
	}
	
	@PostMapping("/add")
	public String addTask(@RequestBody @Valid TaskEntity task) {
		service.addTask(task);
		return "succesfuly save";
	}
	
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "succesfuly deleted";
	}
	@GetMapping("/{id}")
	public Optional<TaskEntity> show(@PathVariable Integer id){
		return service.GetAll(id);
		
	}
	@PutMapping("/{id}")
	public Optional<TaskEntity> update(@PathVariable Integer id, @RequestBody TaskEntity task){
		return service.update(id, task);
		
	}

}
