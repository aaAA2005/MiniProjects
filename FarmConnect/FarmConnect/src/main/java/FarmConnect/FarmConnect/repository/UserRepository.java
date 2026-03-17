package FarmConnect.FarmConnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import FarmConnect.FarmConnect.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByGmail(String gmail);

}
