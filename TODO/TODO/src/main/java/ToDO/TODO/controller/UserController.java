package ToDO.TODO.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ToDO.TODO.entity.UserEntity;
import ToDO.TODO.service.UserService;
import jakarta.validation.Valid;




@RestController
@RequestMapping(path = "/userss")
//@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService us;
	
	
	@PostMapping("/add")
	public String AddUser(@RequestBody @Valid UserEntity user) {
		
		us.addUser(user);
		return "succesfuly save";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		us.delete(id);
		return "succesfuly deleted";
	}
	@GetMapping("/{id}")
	public Optional<UserEntity> Show(@PathVariable Integer id){
		return us.GetAll(id);
		
	}
	@PutMapping("/{id}")
	public Optional<UserEntity> Update(@PathVariable Integer id, @RequestBody UserEntity user){
		return us.update(id, user);
		
	}
	
	
	
	

}
