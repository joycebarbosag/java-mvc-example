package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.models.ReportModel;
import com.example.demo.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<ReportModel> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<ReportModel> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    public ReportModel createReport(ReportModel report) {
        return reportRepository.save(report);
    }

    public ResponseEntity<ReportModel> updatePartialReport(Long id, ReportModel reportUpdate) {
        try {
            Optional<ReportModel> existingReport = reportRepository.findById(id);

            if (existingReport.isPresent()) {
                ReportModel report = existingReport.get();

                if (reportUpdate.getDescription() != null) {
                    report.setDescription(reportUpdate.getDescription());
                }
                report.setFire(reportUpdate.isFire());
                report.setStatus(reportUpdate.isStatus());

                ReportModel updatedReport = reportRepository.save(report);
                return ResponseEntity.ok(updatedReport);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Object> deleteReport(Long id) {
        try {
            Optional<ReportModel> report = reportRepository.findById(id);
            
            if (report.isPresent()) {
                reportRepository.deleteById(id);
                return ResponseEntity.ok().body("Report deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Report not found with id: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error deleting report: " + e.getMessage());
        }
    }

}
