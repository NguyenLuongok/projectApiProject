package com.poly.api.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Entity
@Table(name = "desiciondetail")
@Data
public class Desiciondetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int decisionDetailId;
    private String folderDesicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decisionId")
    private Desicion desicion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "desiciondetail")
    private Set<Decisionupdate> decisionupdates = new HashSet<Decisionupdate>();

    public Desiciondetail() {

    }

    public Desiciondetail(String folderDesicion, Desicion desicion, Student student) {
        this.folderDesicion = folderDesicion;
        this.desicion = desicion;
        this.student = student;
    }
}
