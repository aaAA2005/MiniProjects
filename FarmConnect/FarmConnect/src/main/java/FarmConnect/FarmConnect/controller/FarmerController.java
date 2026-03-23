package FarmConnect.FarmConnect.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FarmConnect.FarmConnect.entity.FarmerEntity;
import FarmConnect.FarmConnect.service.FarmerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/farmers")
@RequiredArgsConstructor
public class FarmerController {

    private final FarmerService farmerService;

    // Farmer yaratmaq
    @PostMapping("/{userId}")
    public ResponseEntity<FarmerEntity> createFarmer(
            @PathVariable Integer userId,
            @RequestBody FarmerEntity farmer) {

        return ResponseEntity.ok(farmerService.createFarmer(userId, farmer));
    }

    // Bütün fermerlər
    @GetMapping
    public ResponseEntity<List<FarmerEntity>> getAllFarmers() {
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }

    // ID ilə tap
    @GetMapping("/{id}")
    public ResponseEntity<FarmerEntity> getFarmer(@PathVariable Integer id) {
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<FarmerEntity> updateFarmer(
            @PathVariable Integer id,
            @RequestBody FarmerEntity farmer) {

        return ResponseEntity.ok(farmerService.updateFarmer(id, farmer));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFarmer(@PathVariable Integer id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.ok("Deleted");
    }
}