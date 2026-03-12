package StudentManagment.studentsManagment.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import StudentManagment.studentsManagment.entity.GradeEntity;

import StudentManagment.studentsManagment.repository.GradeRepository;

@Service
public class GradeService {
	
	@Autowired
	private GradeRepository repository;
	
	public void add(GradeEntity grade) {
		repository.save(grade);
		
	}
	public List<GradeEntity> getByStudent(Integer studentId) {
	        return repository.findByStudentId(studentId);
	    }
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
