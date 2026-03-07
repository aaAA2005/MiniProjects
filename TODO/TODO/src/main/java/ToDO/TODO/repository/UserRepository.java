package ToDO.TODO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ToDO.TODO.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
