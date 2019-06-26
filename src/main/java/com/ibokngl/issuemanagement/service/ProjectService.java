package com.ibokngl.issuemanagement.service;

import com.ibokngl.issuemanagement.dto.ProjectDto;
import com.ibokngl.issuemanagement.util.Tpage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long Id);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    Tpage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDto project);

    ProjectDto update(Long id, ProjectDto project);
}
