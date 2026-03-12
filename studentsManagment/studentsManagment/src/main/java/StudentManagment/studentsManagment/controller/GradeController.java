package StudentManagment.studentsManagment.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import StudentManagment.studentsManagment.entity.GradeEntity;

import StudentManagment.studentsManagment.service.GradeService;

import jakarta.validation.Valid;
@RestController
@RequestMapping(path = "/grades")
//@CrossOrigin(origins = "*")
public class GradeController {

	

			@Autowired
			private GradeService s;
			
			
			@PostMapping("/add")
			public String Add(@RequestBody @Valid GradeEntity grade) {
				
				s.add(grade);
				return "succesfuly save";
			}
			
			@DeleteMapping("/{id}")
			public String delete(@PathVariable Integer id) {
				s.delete(id);
				return "succesfuly deleted";
			}
			@GetMapping("/student/{studentId}")
			public List<GradeEntity> Show(@PathVariable Integer id){
				return s.getByStudent(id);
			}	
}
