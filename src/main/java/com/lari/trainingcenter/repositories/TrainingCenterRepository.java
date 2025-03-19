package com.lari.trainingcenter.repositories;

import com.lari.trainingcenter.models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    @Query("SELECT tc FROM TrainingCenter tc " +
            "WHERE (:centerName IS NULL OR tc.centerName LIKE %:centerName%) " +
            "AND (:city IS NULL OR tc.address.city = :city) " +
            "AND (:state IS NULL OR tc.address.state = :state) " +
            "AND (:minCapacity IS NULL OR tc.studentCapacity >= :minCapacity) " +
            "AND (:maxCapacity IS NULL OR tc.studentCapacity <= :maxCapacity) " +
            "AND (:courseOffered IS NULL OR :courseOffered MEMBER OF tc.coursesOffered)")
    List<TrainingCenter> findFiltered(
            @Param("centerName") String centerName,
            @Param("city") String city,
            @Param("state") String state,
            @Param("minCapacity") Integer minCapacity,
            @Param("maxCapacity") Integer maxCapacity,
            @Param("courseOffered") String courseOffered
    );
}
