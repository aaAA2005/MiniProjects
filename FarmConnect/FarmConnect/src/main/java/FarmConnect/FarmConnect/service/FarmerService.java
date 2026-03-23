package FarmConnect.FarmConnect.service;

import java.util.List;

import FarmConnect.FarmConnect.entity.FarmerEntity;

public interface FarmerService {

    FarmerEntity createFarmer(Integer userId, FarmerEntity farmer);

    FarmerEntity getFarmerById(Integer id);

    List<FarmerEntity> getAllFarmers();

    FarmerEntity updateFarmer(Integer id, FarmerEntity farmer);

    void deleteFarmer(Integer id);
}
