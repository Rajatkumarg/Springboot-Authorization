package com.rajat.dto;

import java.util.Date;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
public class GenevaFileDTO {
   
    private String fileName;
    private String geneva_UUID;
    private int version;
    private String uploadedBy;
    private Date uploadedDate;

    public GenevaFileDTO() {
    }

    public GenevaFileDTO(String fileName, String geneva_UUID, int version, String uploadedBy, Date uploadedDate) {
        this.fileName = fileName;
        this.geneva_UUID = geneva_UUID;
        this.version = version;
        this.uploadedBy = uploadedBy;
        this.uploadedDate = uploadedDate;
    }

    

}
