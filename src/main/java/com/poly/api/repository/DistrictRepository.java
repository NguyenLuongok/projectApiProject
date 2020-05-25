package com.poly.api.repository;

import com.poly.api.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface DistrictRepository extends JpaRepository<District, Integer> {
    District findByDistrictName(String name);
}
