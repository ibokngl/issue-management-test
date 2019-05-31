package com.ibokngl.issuemanagement.service.Impl;

import com.ibokngl.issuemanagement.entity.Project;
import com.ibokngl.issuemanagement.repository.ProjectRepository;
import com.ibokngl.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    public Project save(Project project) {
        //StringUtils.isEmpty(project.getProjectCode())
        if (project.getProjectCode()==null && project.getProjectCode() != ""){
            throw new IllegalArgumentException("ProjectCode cannot bu null");
        }

        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long Id) {
        return projectRepository.getOne(Id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {

        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
