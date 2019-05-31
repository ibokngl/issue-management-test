package com.ibokngl.issuemanagement.repository;

import com.ibokngl.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository bir interface bir tabloya hizmet edecek Long : bu tablonun idsinin tipi nedir
public interface IssueRepository extends JpaRepository<Issue,Long> {
}
