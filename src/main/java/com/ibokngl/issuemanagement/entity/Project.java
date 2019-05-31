package com.ibokngl.issuemanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@NoArgsConstructor  // constructor oluşturmamızı sağlar
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Project extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "projectcode",unique = true)
    private String projectCode;

    @Column(name = "projectname",length = 100)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;
}
