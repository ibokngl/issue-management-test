package com.ibokngl.issuemanagement.api;

import com.ibokngl.issuemanagement.dto.ProjectDto;
import com.ibokngl.issuemanagement.service.Impl.ProjectServiceImpl;
import com.ibokngl.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById (@PathVariable(value = "id",required = true) Long id){
        ProjectDto projectDto =projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    // CREATE İŞLEMİNİ YAPIYORUZ
    //@Valid Null bişeyi kayıt ettirmeyecek
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody  ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    // UPDATE İŞLEMİNİ YAPIYORUZ
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id",required = true) Long id,@Valid @RequestBody  ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }

}
