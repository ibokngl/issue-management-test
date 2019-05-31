package com.ibokngl.issuemanagement.service;

import com.ibokngl.issuemanagement.dto.IssueDto;
import com.ibokngl.issuemanagement.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue);
    IssueDto getById(Long Id);
    Tpage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(IssueDto issue);
}
