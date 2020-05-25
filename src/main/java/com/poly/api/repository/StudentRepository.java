package com.poly.api.repository;

import com.poly.api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.nation.nationId =:naId order by s.studentId desc ")
    List<Student> findAllByNationId(@Param("naId") int nationId);

    @Query("select s from Student s where s.province.provinceId =:prId order by s.studentId desc ")
    List<Student> findAllByProvinceId(@Param("prId") int provinceId);

     @Query("select s from Student s where s.district.districtId =:dtId order by s.studentId desc ")
    List<Student> findAllByDistrictId(@Param("dtId") int districtId);

     @Query("select s from Student s where s.trainingsystem.trainingSystemId =:trsId order by s.studentId desc ")
    List<Student> findAllByTrainingSystemId(@Param("trsId") int trainingSystemId);

     @Query("select s from Student s where s.facility.facilityId =:faId order by s.studentId desc ")
    List<Student> findAllByFacilityId(@Param("faId") int facilityId);

     @Query("select s from Student s where s.school.schoolId =:schId order by s.studentId desc ")
    List<Student> findAllBySchoolId(@Param("schId") int schoolId);

     @Query("select s from Student s where s.specialized.specializedId =:spId order by s.studentId desc ")
    List<Student> findAllBySpecializedId(@Param("spId") int specializedId);


}
