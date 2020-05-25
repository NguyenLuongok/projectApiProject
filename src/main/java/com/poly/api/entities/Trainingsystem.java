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
@Table(name = "trainingsystem")
@Data
public class Trainingsystem {
    @Id
    private int trainingSystemId;
    private String trainingSystemName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainingsystem")
    private Set<Student> students = new HashSet<Student>(0);

    public Trainingsystem() {
    }

    public Trainingsystem(int trainingSystemId, String trainingSystemName) {
        this.trainingSystemId = trainingSystemId;
        this.trainingSystemName = trainingSystemName;
    }

    public Trainingsystem(String trainingSystemName) {
        this.trainingSystemName = trainingSystemName;
    }
}
