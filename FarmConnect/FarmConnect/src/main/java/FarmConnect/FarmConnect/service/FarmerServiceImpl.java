package FarmConnect.FarmConnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import FarmConnect.FarmConnect.entity.FarmerEntity;
import FarmConnect.FarmConnect.entity.Role;
import FarmConnect.FarmConnect.entity.UserEntity;
import FarmConnect.FarmConnect.repository.FarmerRepository;
import FarmConnect.FarmConnect.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;
    private final UserRepository userRepository;

    @Override
    public FarmerEntity createFarmer(Integer userId, FarmerEntity farmer) {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Role dəyiş
        user.setRole(Role.FARMER);

        farmer.setUser(user);

        return farmerRepository.save(farmer);
    }

    @Override
    public FarmerEntity getFarmerById(Integer id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
    }

    @Override
    public List<FarmerEntity> getAllFarmers() {
        return farmerRepository.findAll();
    }

    @Override
    public FarmerEntity updateFarmer(Integer id, FarmerEntity updatedFarmer) {

        FarmerEntity farmer = getFarmerById(id);

        farmer.setFarmName(updatedFarmer.getFarmName());
        farmer.setDescription(updatedFarmer.getDescription());
        farmer.setExperienceYears(updatedFarmer.getExperienceYears());

        return farmerRepository.save(farmer);
    }

    @Override
    public void deleteFarmer(Integer id) {
        farmerRepository.deleteById(id);
    }
}
