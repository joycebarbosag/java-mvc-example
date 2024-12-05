package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.models.ReportAddressModel;
import com.example.demo.models.ReportModel;
import com.example.demo.services.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ReportModel>> getAllReports() {
        List<ReportModel> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportModel> getReportById(@PathVariable Long id) {
        Optional<ReportModel> report = reportService.getReportById(id);

        if (report.isPresent()) {
            return ResponseEntity.ok(report.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/createReport", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ReportModel> createReport(
            @RequestParam("description") String description,
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam("userId") Long userId,
            @RequestParam("address") String addressJson) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ReportAddressModel address = mapper.readValue(addressJson, ReportAddressModel.class);
            
            ReportModel createdReport = reportService.createReport(description, image, address, userId);
            return ResponseEntity.ok(createdReport);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/updateReport/{id}")
    public ResponseEntity<ReportModel> updatePartialReport(
            @PathVariable Long id,
            @RequestBody ReportModel reportUpdate) {
        return reportService.updatePartialReport(id, reportUpdate);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReport(@PathVariable Long id) {
        return reportService.deleteReport(id);
    }
}
