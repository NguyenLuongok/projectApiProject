package com.poly.api.dto;

import com.poly.api.entities.Desicion;
import com.poly.api.entities.Student;
import lombok.Data;

/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class DesiciondetailDto {
    private int decisionDetailId;
    private String folderDesicion;
    private int desicionId;
    private String desicionName;
    private int studentId;
    private String email;

    public DesiciondetailDto() {
    }

    public DesiciondetailDto(int decisionDetailId, String folderDesicion, int desicionId, String desicionName, int studentId, String email) {
        this.decisionDetailId = decisionDetailId;
        this.folderDesicion = folderDesicion;
        this.desicionId = desicionId;
        this.desicionName = desicionName;
        this.studentId = studentId;
        this.email = email;
    }

    public DesiciondetailDto(String folderDesicion, int desicionId, String desicionName, int studentId, String email) {
        this.folderDesicion = folderDesicion;
        this.desicionId = desicionId;
        this.desicionName = desicionName;
        this.studentId = studentId;
        this.email = email;
    }
}
