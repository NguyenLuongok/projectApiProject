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
@Table(name = "district")
@Data
public class District {
    @Id
    private int districtId;
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provinceId")
    private Province province;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
    private Set<Student> students = new HashSet<Student>(0);

    public District() {
    }

    public District(int districtId, String districtName, Province province) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.province = province;
    }

    public District(String districtName, Province province) {
        this.districtName = districtName;
        this.province = province;
    }
}
