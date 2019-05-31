package com.ibokngl.issuemanagement.service.Impl;

import com.ibokngl.issuemanagement.entity.IssueHistory;
import com.ibokngl.issuemanagement.repository.IssueHistoryRepository;
import com.ibokngl.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issuehistory) {
        if (issuehistory.getDate()==null){
            throw new IllegalArgumentException("Issue cannot be null");
        }
        return issueHistoryRepository.save(issuehistory);
    }

    @Override
    public IssueHistory getById(Long Id) {
        return issueHistoryRepository.getOne(Id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
