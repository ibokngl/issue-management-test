package com.ibokngl.issuemanagement.dto;

import com.ibokngl.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;
@Data
public class IssueDto {
    private Long id;
    private String descripton;
    private String details;
    private Date date;
    private IssueStatus issueStatus;
    private UserDto assignee;
    private ProjectDto project;
}
