package com.example.task_management.controller;

import com.example.task_management.model.Workspace;
import com.example.task_management.service.WorkspaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/workspaces")
public class WorkspaceController {

    private WorkspaceService workspaceService;

    @PostMapping
    public ResponseEntity<Workspace> createWorkspace(@RequestBody Workspace workspace) {
        Workspace createWorkspace = workspaceService.createWorkspace(workspace);
        return ResponseEntity.ok(workspace);
    }
}
