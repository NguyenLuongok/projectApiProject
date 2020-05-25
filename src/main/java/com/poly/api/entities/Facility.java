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
@Table(name = "facility")
@Data
public class Facility {
    @Id
    private int facilityId;
    private String facilityName;
//    private int campaignId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facility")
    private Set<Student> students = new HashSet<Student>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facility")
    private Set<Campaigndetail> campaigndetails = new HashSet<Campaigndetail>(0);


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facility")
//    private Set<Campaign> campaigns = new HashSet<Campaign>(0);

    public Facility() {
    }

    public Facility(int facilityId, String facilityName) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
    }

    public Facility(String facilityName) {
        this.facilityName = facilityName;
    }
}
