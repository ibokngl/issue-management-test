package com.ibokngl.issuemanagement.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

//@Entity : Veritabanında bir tabloya karşılık gelmesi için kullanılır.
//@Id : Birincil anahtar
//@GeneratedValue : Otomatik artan

@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor  // constructor oluşturmamızı sağlar
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description",length = 1000)
    private String descripton;

    @Column(name = "details",length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issuestatus",length = 4000)
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id") // İlişkisel bir sutun ismi vermek için
    @ManyToOne(optional = true,fetch =FetchType.LAZY)// Fetch join atılan tablodan veri çekmemize yarar
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}
