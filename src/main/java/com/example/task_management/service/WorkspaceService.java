package com.example.task_management.service;

import com.example.task_management.model.User;
import com.example.task_management.model.Workspace;
import com.example.task_management.model.WorkspaceState;
import com.example.task_management.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {

    @Autowired
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepositoryworkspace) {
        this.workspaceRepository = workspaceRepositoryworkspace;
    }

    public Workspace createWorkspace(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }
    public List<Workspace> getAllWorkspaces(){ return workspaceRepository.findAll();}

    public Workspace getWorkspaceById(Long id){
        return workspaceRepository.findById(id).orElseThrow(()-> new RuntimeException("Workspace not found"));
    }

    public Workspace changeWorkspaceState(Long id, String state){
        Workspace workspace = getWorkspaceById(id);
        workspace.setState(WorkspaceState.valueOf(state.toUpperCase()));
        return workspaceRepository.save(workspace);
    }

    public List<User> getMembers(Long workspaceId){
        return getWorkspaceById(workspaceId).getMembers();
    }

}
