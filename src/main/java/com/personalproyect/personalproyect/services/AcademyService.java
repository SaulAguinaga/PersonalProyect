package com.personalproyect.personalproyect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.personalproyect.personalproyect.exception.AcademyNotFoundException;
import com.personalproyect.personalproyect.models.Academy;
import com.personalproyect.personalproyect.payloads.AcademyPayload;
import com.personalproyect.personalproyect.repositories.AcademyRepository;

import jakarta.transaction.Transactional;

@Service
public class AcademyService implements BaseService<Academy> {

    @Autowired
    private AcademyRepository academyRepository;

    @Override
    public List<Academy> findAll() {
        return academyRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Academy> findAll(Pageable pageable) {
        return academyRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Academy findById(Long id) {
        return academyRepository.findById(id)
        .orElseThrow(() -> new AcademyNotFoundException("Academy not found with id: " + id));
    }

    @Transactional
    public void saveAcademy(Long id, AcademyPayload academy) {
        Academy academyToAdd = new Academy(id, academy.getName(), academy.getLocation(), academy.getContact(), academy.getPhone(), academy.getImage(), null);
        academyRepository.save(academyToAdd);
    }

    @Override
    public void deleteById(Long id) {
        Academy academyDelete = findById(id);
        academyRepository.deleteById(academyDelete.getId());
    }

    public Academy updateAcademy(Long id, Academy academyDetails) {
        Academy academy = findById(id);
        academy.setName(academyDetails.getName());
        academy.setLocation(academyDetails.getLocation());
        academy.setContact(academyDetails.getContact());
        academy.setPhone(academyDetails.getPhone());
        return academyRepository.save(academy);
    }

    @Override
    public Academy save(Academy entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
   

}
