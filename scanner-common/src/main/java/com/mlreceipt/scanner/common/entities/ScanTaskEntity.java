package com.mlreceipt.scanner.common.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "ScanTask")
public class ScanTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String uuid;
    String name;

    ScanTaskStatusEnum status;

    public ScanTaskEntity() {
        status=ScanTaskStatusEnum.CREATED;
        this.uuid = UUID.randomUUID().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScanPairEntity> getScanPairList() {
        return scanPairList;
    }

    public void addScanPair(ScanPairEntity scanPair) {
        if (scanPair != null)
            scanPair.setScanTask(this);
        this.scanPairList.add(scanPair);
    }

    @OneToMany(mappedBy = "scanTask")
    @JsonManagedReference("scantask-scanpair")
    List<ScanPairEntity> scanPairList = new LinkedList<>();

}
