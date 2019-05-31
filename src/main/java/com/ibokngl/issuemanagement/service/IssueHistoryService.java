package com.ibokngl.issuemanagement.service;

import com.ibokngl.issuemanagement.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issuehistory);
    IssueHistory getById(Long Id);
    Page<IssueHistory> getAllPageable(Pageable pageable);
    Boolean delete(IssueHistory issueHistory);
}
