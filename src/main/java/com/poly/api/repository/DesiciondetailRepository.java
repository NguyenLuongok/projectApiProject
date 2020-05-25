package com.poly.api.repository;

import com.poly.api.entities.Desiciondetail;
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
public interface DesiciondetailRepository extends JpaRepository<Desiciondetail, Integer> {

    @Query("select d from Desiciondetail d where d.desicion.decisionId =:deId order by d.decisionDetailId desc")
    public List<Desiciondetail> findAllByDesicionId(@Param("deId") int id);

    @Query("select d from Desiciondetail d where d.student.studentId =:stId order by d.decisionDetailId desc")
    public List<Desiciondetail> findAllByStudentId(@Param("stId") int id);
}
