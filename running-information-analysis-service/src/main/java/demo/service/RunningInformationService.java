package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {
    List<RunningInformation> saveAllRunningInformation(List<RunningInformation> runningInformations);

    Page<RunningInformation> findAll(Pageable pageable);

    void deleteByRunningId(String runningId);
}
