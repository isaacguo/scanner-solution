package com.mlreceipt.scanner.data.repositories;

import com.mlreceipt.scanner.common.entities.ScanPairEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanPairRepository extends JpaRepository<ScanPairEntity, Long> {
}
