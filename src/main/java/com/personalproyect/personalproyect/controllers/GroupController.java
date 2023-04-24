package com.personalproyect.personalproyect.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalproyect.personalproyect.models.Group;
import com.personalproyect.personalproyect.services.GroupService;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;


    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    public Group getfindById(@PathVariable Long id) {
        return groupService.findById(id);
    }


    @PostMapping(path = "")
    public void createGroup(@RequestBody Group group) {
        groupService.saveGroup(null, group);
    }

    @PutMapping("/update/{id}")
    public Group updateGroup(@PathVariable Long id, @RequestBody Group groupDetails) {
        return groupService.updateGroup(id, groupDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id) {
        groupService.deleteById(id);
        return ResponseEntity.ok("Group deleted successfully");
    }
}
