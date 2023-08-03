package com.arms.openfeign.controller;

import com.arms.openfeign.domain.CloudJiraIssueDTO;
import com.arms.openfeign.domain.CloudJiraIssueInputDTO;
import com.arms.openfeign.service.OpenFeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class OpenFeignController {
    private final OpenFeignClient openFeignClient;

    public OpenFeignController(OpenFeignClient openFeignClient) {
        this.openFeignClient = openFeignClient;
    }

    @PostMapping("")
    public CloudJiraIssueDTO createIssue(@RequestBody CloudJiraIssueInputDTO cloudJiraIssueInputDTO) {
        return openFeignClient.createIssue(cloudJiraIssueInputDTO);
    }

    @GetMapping("/{issueKeyOrId}")
    public CloudJiraIssueDTO getIssue(@PathVariable String issueKeyOrId) {
        return openFeignClient.getIssue(issueKeyOrId);
    }

}
