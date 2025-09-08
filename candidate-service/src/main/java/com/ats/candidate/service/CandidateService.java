package com.ats.candidate.service;

import com.ats.candidate.dto.CandidateDto;
import com.ats.candidate.model.Candidate;
import com.ats.candidate.repository.CandidateRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    private final CandidateRepositoryImpl candidateRepository;
    private final ModelMapper modelMapper;

    public CandidateService(CandidateRepositoryImpl candidateRepository, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
    }

    public CandidateDto addCandidate(CandidateDto dto) {
        Candidate candidate = modelMapper.map(dto, Candidate.class);
        Candidate saved = candidateRepository.addCandidate(candidate);
        return modelMapper.map(saved, CandidateDto.class);
    }

    public CandidateDto getCandidateById(int id) {
        Candidate candidate = candidateRepository.getCandidateById(id);
        return modelMapper.map(candidate, CandidateDto.class);
    }

    public List<CandidateDto> getAllCandidates() {
        return candidateRepository.getAllCandidates()
                .stream()
                .map(c -> modelMapper.map(c, CandidateDto.class))
                .collect(Collectors.toList());
    }

    public CandidateDto updateCandidate(CandidateDto dto) {
        Candidate candidate = modelMapper.map(dto, Candidate.class);
        Candidate updated = candidateRepository.updateCandidate(candidate);
        return modelMapper.map(updated, CandidateDto.class);
    }

    public void deleteCandidate(int id) {
        candidateRepository.deleteCandidate(id);
    }
}
