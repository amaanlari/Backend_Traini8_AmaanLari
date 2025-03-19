package com.lari.trainingcenter.repositories;

import com.lari.trainingcenter.models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
