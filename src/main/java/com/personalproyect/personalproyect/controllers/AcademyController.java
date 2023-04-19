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

import com.personalproyect.personalproyect.models.Academy;
import com.personalproyect.personalproyect.payloads.AcademyPayload;
import com.personalproyect.personalproyect.services.AcademyService;

@RestController
@RequestMapping("/api/academies")
public class AcademyController {
    
private final AcademyService academyService;

    public AcademyController(AcademyService academyService) {
    this.academyService = academyService;
    }

    @GetMapping
    public List<Academy> getAllAcademies() {
        return academyService.findAll();
    }

    @GetMapping("/{id}")
    public Academy getfindById(@PathVariable Long id) {
        return academyService.findById(id);
    }

    @PostMapping(path = "")
    public void createAcademy(@RequestBody AcademyPayload academy) {
        academyService.saveAcademy(null, academy);
    }

    @PutMapping("/update/{id}")
    public Academy updateAcademy(@PathVariable Long id, @RequestBody Academy academyDetails) {
        return academyService.updateAcademy(id, academyDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAcademy(@PathVariable Long id) {
        academyService.deleteById(id);
        return ResponseEntity.ok("Academy deleted successfully");
    }
}
