package com.arms.openfeign.controller;

import com.arms.openfeign.domain.CloudJiraIssueDTO;
import com.arms.openfeign.domain.CloudJiraIssueInputDTO;
import com.arms.openfeign.service.OpenFeignClient2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test2")
public class OpenFeignController2 {
    private final OpenFeignClient2 openFeignClient2;

    public OpenFeignController2(OpenFeignClient2 openFeignClient2) {
        this.openFeignClient2 = openFeignClient2;
    }

    @PostMapping("")
    public CloudJiraIssueDTO createIssue(@RequestBody CloudJiraIssueInputDTO cloudJiraIssueInputDTO) {
        return openFeignClient2.createIssue(cloudJiraIssueInputDTO);
    }

    @GetMapping("/{issueKeyOrId}")
    public CloudJiraIssueDTO getIssue(@PathVariable String issueKeyOrId) {
        return openFeignClient2.getIssue(issueKeyOrId);
    }

}
