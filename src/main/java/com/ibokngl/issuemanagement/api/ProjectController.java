package com.ibokngl.issuemanagement.api;

import com.ibokngl.issuemanagement.dto.ProjectDto;
import com.ibokngl.issuemanagement.service.Impl.ProjectServiceImpl;
import com.ibokngl.issuemanagement.util.ApiPaths;
import com.ibokngl.issuemanagement.util.Tpage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value =ApiPaths.ProjectCtrl.CTRL ,description = "Project APIs")
@Slf4j
@CrossOrigin("*")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;
    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation",response = ProjectDto.class)
    public ResponseEntity<Tpage<ProjectDto>> getAllByPagination(Pageable pageable) {
        Tpage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById (@PathVariable(value = "id",required = true) Long id){
        //log.info("ProjectController -> GetById -> ");
        //log.info("ProjectController -> GetById -> PARAM : " + id);
        ProjectDto projectDto =projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    // CREATE İŞLEMİNİ YAPIYORUZ
    //@Valid Null bişeyi kayıt ettirmeyecek
    @PostMapping
    @ApiOperation(value = "Create Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody  ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    // UPDATE İŞLEMİNİ YAPIYORUZ
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id",required = true) Long id,@Valid @RequestBody  ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }

}
