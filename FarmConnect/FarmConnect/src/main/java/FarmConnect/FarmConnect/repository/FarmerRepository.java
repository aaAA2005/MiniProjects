package FarmConnect.FarmConnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FarmConnect.FarmConnect.entity.FarmerEntity;
import FarmConnect.FarmConnect.entity.UserEntity;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerEntity, Integer> {

    Optional<FarmerEntity> findByUser(UserEntity user);
}