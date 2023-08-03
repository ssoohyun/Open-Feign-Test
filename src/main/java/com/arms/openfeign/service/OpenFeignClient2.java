package com.arms.openfeign.service;

import com.arms.config.OpenFeignConfig2;
import com.arms.openfeign.domain.CloudJiraIssueDTO;
import com.arms.openfeign.domain.CloudJiraIssueInputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="test2", url="${api.cloud.jira.issue2}", configuration = OpenFeignConfig2.class)
public interface OpenFeignClient2 {

    @PostMapping("")
    CloudJiraIssueDTO createIssue(@RequestBody CloudJiraIssueInputDTO cloudJiraIssueInputDTO);

    @GetMapping("/{issueKeyOrId}")
    CloudJiraIssueDTO getIssue(@PathVariable String issueKeyOrId);

}
