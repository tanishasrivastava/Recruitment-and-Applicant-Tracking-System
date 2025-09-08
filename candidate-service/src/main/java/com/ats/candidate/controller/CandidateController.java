package com.ats.candidate.controller;

import com.ats.candidate.dto.CandidateDto;
import com.ats.candidate.service.CandidateService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public CandidateDto addCandidate(@RequestBody CandidateDto dto) {
        return candidateService.addCandidate(dto);
    }

    @GetMapping("/{id}")
    public CandidateDto getCandidate(@PathVariable int id) {
        return candidateService.getCandidateById(id);
    }

    @GetMapping
    public List<CandidateDto> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @PutMapping("/{id}")
    public CandidateDto updateCandidate(@PathVariable int id, @RequestBody CandidateDto dto) {
        dto.setCandidateId(id);
        return candidateService.updateCandidate(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id) {
        candidateService.deleteCandidate(id);
    }
}
