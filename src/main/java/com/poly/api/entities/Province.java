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
@Table(name = "province")
@Data
public class Province {
    @Id
    private int provinceId;
    private String provinceName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    private Set<Student> students = new HashSet<Student>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    private Set<District> districts = new HashSet<District>(0);

    public Province() {

    }

    public Province(int provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }
}
