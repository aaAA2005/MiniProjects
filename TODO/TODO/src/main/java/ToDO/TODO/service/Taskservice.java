package ToDO.TODO.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ToDO.TODO.entity.TaskEntity;

import ToDO.TODO.repository.TaskRepository;

@Service
public class Taskservice {
	

	private TaskRepository repository;
	
	public Taskservice(TaskRepository repository) {
		this.repository=repository;
	}
	
	public void addTask(TaskEntity task) {
		
		repository.save(task);
		
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<TaskEntity> GetAll(Integer id){
		return repository.findById(id);
	}
	
	public Optional<TaskEntity> update(Integer id, TaskEntity task){
		return repository.findById(id).map(t->{
			t.setTitle(task.getTitle());
			t.setDate(task.getDate());
			return repository.save(t);
		});
	}

}
