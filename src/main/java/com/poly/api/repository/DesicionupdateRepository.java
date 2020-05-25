package com.poly.api.repository;

import com.poly.api.entities.Decisionupdate;
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
public interface DesicionupdateRepository extends JpaRepository<Decisionupdate,Integer> {

    @Query("select d from Decisionupdate d where d.desiciondetail.decisionDetailId =:deDetailId order by d.decisionUpdateId desc ")
    public List<Decisionupdate> findAllByDesiciondetailId(@Param("deDetailId") int desicionDetailId);
}
