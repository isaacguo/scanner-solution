package com.mlreceipt.scanner.data.repositories;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScanTaskRepository extends JpaRepository<ScanTaskEntity, Long> {

    List<ScanTaskEntity> findByStatus(ScanTaskStatusEnum status);

    ScanTaskEntity findByUuid(String uuid);
}
