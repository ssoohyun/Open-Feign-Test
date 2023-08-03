package com.arms.openfeign.service;

import com.arms.config.OpenFeignConfig;
import com.arms.openfeign.domain.CloudJiraIssueDTO;
import com.arms.openfeign.domain.CloudJiraIssueInputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="test", url="${api.cloud.jira.issue}", configuration = OpenFeignConfig.class)
public interface OpenFeignClient {

    @PostMapping("")
    CloudJiraIssueDTO createIssue(@RequestBody CloudJiraIssueInputDTO cloudJiraIssueInputDTO);

    @GetMapping("/{issueKeyOrId}")
    CloudJiraIssueDTO getIssue(@PathVariable String issueKeyOrId);

}
