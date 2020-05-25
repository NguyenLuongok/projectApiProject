package com.poly.api.repository;

import com.poly.api.entities.Trainingsystem;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface TrainingsystemRepository extends JpaRepository<Trainingsystem, Integer> {
    Trainingsystem findByTrainingSystemName(String name);
}
