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
@Data
@Table(name = "school")
public class School {
    @Id
    private int schoolId;
    private String schoolName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
    private Set<Student> students = new HashSet<Student>(0);

    public School() {
    }

    public School(int schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }
}
