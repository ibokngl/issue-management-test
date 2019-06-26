package com.ibokngl.issuemanagement.api;


import com.ibokngl.issuemanagement.dto.IssueDto;
import com.ibokngl.issuemanagement.service.Impl.IssueServiceImpl;
import com.ibokngl.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl ;

    public IssueController(IssueServiceImpl issueServiceımpl) {
        this.issueServiceImpl = issueServiceımpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById (@PathVariable(value = "id",required = true) Long id){
        IssueDto projectDto =issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    // CREATE İŞLEMİNİ YAPIYORUZ
    //@Valid Null bişeyi kayıt ettirmeyecek
    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody  IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    // UPDATE İŞLEMİNİ YAPIYORUZ
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value="id",required = true) Long id,@Valid @RequestBody  IssueDto project){
        return ResponseEntity.ok(issueServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

}
