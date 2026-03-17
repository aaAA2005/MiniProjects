package FarmConnect.FarmConnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FarmConnect.FarmConnect.entity.UserEntity;
import FarmConnect.FarmConnect.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public void register(UserEntity user) {
		repository.save(user);
	}

	   public UserEntity getUserById(Integer id) {
	        return repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    }

	public Optional<UserEntity> login(String gmail) {
		return repository.findByGmail(gmail);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
    @Transactional
    public UserEntity updateUser(Integer id, UserEntity updatedUser) {
        Optional<UserEntity> optionalUser = repository.findById(id);
        if(optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setGmail(updatedUser.getGmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setRole(updatedUser.getRole());
            return repository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

}
