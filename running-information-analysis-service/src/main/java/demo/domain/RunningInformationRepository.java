package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningInformationRepository extends JpaRepository<RunningInformation, String> {
    Page<RunningInformation> findAll(Pageable pageable);
}
