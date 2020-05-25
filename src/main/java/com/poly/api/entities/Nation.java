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
@Table(name = "nation")
@Data
public class Nation {
    @Id
    private int nationId;
    private String nationName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nation")
    private Set<Student> students = new HashSet<Student>(0);

    public Nation() {

    }

    public Nation(int nationId, String nationName) {
        this.nationId = nationId;
        this.nationName = nationName;
    }

    public Nation(String nationName) {
        this.nationName = nationName;
    }
}
