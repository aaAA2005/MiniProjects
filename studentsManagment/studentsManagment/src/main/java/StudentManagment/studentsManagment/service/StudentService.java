package StudentManagment.studentsManagment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentManagment.studentsManagment.entity.StudentEntity;
import StudentManagment.studentsManagment.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public void add(StudentEntity student) {
		
		repository.save(student);
	}
	
	public Optional<StudentEntity> getAll(Integer id){
		
		return repository.findById(id);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
