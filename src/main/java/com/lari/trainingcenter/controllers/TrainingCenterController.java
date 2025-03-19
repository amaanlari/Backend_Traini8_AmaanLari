package com.lari.trainingcenter.controllers;

import com.lari.trainingcenter.dtos.TrainingCenterDto;
import com.lari.trainingcenter.services.TrainingCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenterDto> createTrainingCenter(@Valid @RequestBody TrainingCenterDto trainingCenterDto) {
        log.info("Received request to create a new training center");
        TrainingCenterDto createdTrainingCenter = trainingCenterService.createTrainingCenter(trainingCenterDto);
        return new ResponseEntity<>(createdTrainingCenter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenterDto>> getAllTrainingCenters(
            @RequestParam(required = false) String centerName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) Integer minCapacity,
            @RequestParam(required = false) Integer maxCapacity,
            @RequestParam(required = false) String courseOffer
    ) {
        log.info("Received request to fetch all training centers");
        List<TrainingCenterDto> trainingCenters = trainingCenterService.getAllTrainingCenters(
                centerName, city, state, minCapacity, maxCapacity, courseOffer);
        return ResponseEntity.ok(trainingCenters);
    }

}
