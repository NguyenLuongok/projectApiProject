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
@Table(name = "specialized")
@Data
public class Specialized {
    @Id
    private int specializedId;
    private String specializedName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "specialized")
    private Set<Student> students = new HashSet<Student>(0);

    public Specialized() {
    }

    public Specialized(int specializedId, String specializedName) {
        this.specializedId = specializedId;
        this.specializedName = specializedName;
    }

    public Specialized(String specializedName) {
        this.specializedName = specializedName;
    }
}
