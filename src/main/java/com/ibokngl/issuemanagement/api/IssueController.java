package com.ibokngl.issuemanagement.api;


import com.ibokngl.issuemanagement.dto.IssueDto;
import com.ibokngl.issuemanagement.dto.ProjectDto;
import com.ibokngl.issuemanagement.service.Impl.IssueServiceImpl;
import com.ibokngl.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value =ApiPaths.IssueCtrl.CTRL,description = "Issue APIs")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl ;

    public IssueController(IssueServiceImpl issueServiceımpl) {
        this.issueServiceImpl = issueServiceımpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById (@PathVariable(value = "id",required = true) Long id){
        IssueDto projectDto =issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    // CREATE İŞLEMİNİ YAPIYORUZ
    //@Valid Null bişeyi kayıt ettirmeyecek
    @PostMapping
    @ApiOperation(value = "Create Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody  IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    // UPDATE İŞLEMİNİ YAPIYORUZ
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value="id",required = true) Long id,@Valid @RequestBody  IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

}
