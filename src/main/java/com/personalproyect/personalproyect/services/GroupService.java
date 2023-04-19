package com.personalproyect.personalproyect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.personalproyect.personalproyect.exception.GroupNotFoundException;
import com.personalproyect.personalproyect.models.Group;
import com.personalproyect.personalproyect.repositories.GroupRepository;

import jakarta.transaction.Transactional;

@Service
public class GroupService implements BaseService<Group>{
    @Autowired
    private GroupRepository groupRepository;
  
    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Group> findAll(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Group findById(Long id) {
        return groupRepository.findById(id)
        .orElseThrow(() -> new GroupNotFoundException("Group not found with id: " + id));
    }

    @Transactional
    public void saveGroup(Long id, Group group) {
        Group groupToAdd = new Group(id, group.getName(), null, null);
        groupRepository.save(groupToAdd);
    }

    @Override
    public void deleteById(Long id) {
        Group groupDelete = findById(id);
        groupRepository.deleteById(groupDelete.getId());
    }

    public Group updateGroup(Long id, Group groupDetails) {
        Group group = findById(id);
        group.setName(groupDetails.getName());
        return groupRepository.save(group);
    }

	@Override
	public Group save(Group entity) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}
    
}
