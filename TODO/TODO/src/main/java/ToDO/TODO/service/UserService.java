package ToDO.TODO.service;

import java.util.Optional;


import org.springframework.stereotype.Service;

import ToDO.TODO.entity.UserEntity;
import ToDO.TODO.repository.UserRepository;

@Service
public class UserService {
	   private final UserRepository repository;

	    public UserService(UserRepository repository){
	        this.repository = repository;
	    }
	
	
	public void addUser(UserEntity user) {
		
		repository.save(user);
		
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<UserEntity> GetAll(Integer id){
		return repository.findById(id);
	}
	
	public Optional<UserEntity> update(Integer id, UserEntity user){
		return repository.findById(id).map(u->{
			u.setName(user.getName());
			u.setSurname(user.getSurname());
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			return repository.save(u);
		});
	}

}
