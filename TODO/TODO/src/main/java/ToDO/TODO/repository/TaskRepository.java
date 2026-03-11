package ToDO.TODO.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ToDO.TODO.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity,Integer> {
	
	

}
