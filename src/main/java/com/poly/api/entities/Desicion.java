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
@Table(name = "desicion")
@Data
public class Desicion {
    @Id
    private int decisionId;
    private String decisionName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "desicion")
    Set<Desiciondetail> desiciondetails = new HashSet<Desiciondetail>();

    public Desicion() {
    }
}
