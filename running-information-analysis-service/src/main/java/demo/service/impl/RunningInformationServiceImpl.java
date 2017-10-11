package demo.service.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationServiceImpl implements RunningInformationService {

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveAllRunningInformation(List<RunningInformation> runningInformations) {
        return this.runningInformationRepository.save(runningInformations);
    }

    @Override
    public Page<RunningInformation> findAll(Pageable pageable) {
        return this.runningInformationRepository.findAll(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        this.runningInformationRepository.delete(runningId);
    }
}

