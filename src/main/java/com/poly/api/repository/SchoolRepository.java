package com.poly.api.repository;

import com.poly.api.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface SchoolRepository extends JpaRepository<School, Integer> {
    School findBySchoolId(int id);

    School findSchoolBySchoolName(String name);
}
