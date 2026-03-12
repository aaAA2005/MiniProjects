package StudentManagment.studentsManagment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StudentManagment.studentsManagment.entity.StudentEntity;
import StudentManagment.studentsManagment.service.StudentService;
import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/students")
//@CrossOrigin(origins = "*")
public class StudentController {

		@Autowired
		private StudentService s;
		
		
		@PostMapping("/add")
		public String Add(@RequestBody @Valid StudentEntity student) {
			
			s.add(student);
			return "succesfuly save";
		}
		
		@DeleteMapping("/{id}")
		public String delete(@PathVariable Integer id) {
			s.delete(id);
			return "succesfuly deleted";
		}
		@GetMapping("/{id}")
		public Optional<StudentEntity> Show(@PathVariable Integer id){
			return s.getAll(id);
		}		
}
