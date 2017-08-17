package com.mlreceipt.scanner.data.repositories;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanTaskRepository extends JpaRepository<ScanTaskEntity, Long> {
}
