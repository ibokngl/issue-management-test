package com.ibokngl.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

//Serializable : Aşağıdaki nesnelerin network taşınması için veya diske yazma yeteneklerin kazanmasını sağlar
 //Bu aşağıdaki nesnelerde hibernatte bir orm nesne olarak tutulacaktır.
//@Data bir lombok aşağıdaki nesnelerin getter setter metodlarını otomatik oluşturuyor
 //Kodun sade olmasını sağlar
//@MappedSuperclass bu anaotation BaseEntity classını diğer classlarda extend etmemizi sağlıyor
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="created_by",length = 100)
    private String createdBy;

    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name="updated_by",length = 100)
    private String updatedBy;

    @Column(name="status")
    private Boolean status;
}
