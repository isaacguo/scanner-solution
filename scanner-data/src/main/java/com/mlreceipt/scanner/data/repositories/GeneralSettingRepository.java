package com.mlreceipt.scanner.data.repositories;

import com.mlreceipt.scanner.common.entities.GeneralSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralSettingRepository extends JpaRepository<GeneralSettingEntity,Long> {

}
