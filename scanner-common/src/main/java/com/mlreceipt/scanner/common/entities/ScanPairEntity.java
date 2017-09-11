package com.mlreceipt.scanner.common.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ScanPair")
public class ScanPairEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String uuid;

    String imagePath;
    String imageName;


    @OneToMany(mappedBy = "scanPair", cascade = CascadeType.ALL)
    @JsonManagedReference("scanpair-scanitem")
    List<ScanItemEntity> scanItems=new LinkedList<>();

    public List<ScanItemEntity> getScanItems() {
        return scanItems;
    }

    public void addScanItem(ScanItemEntity scanItem) {
        if (scanItem != null) {
            scanItem.setScanPair(this);
            this.scanItems.add(scanItem);
        }
    }

    @ManyToOne
    @JsonBackReference("scantask-scanpair")
    ScanTaskEntity scanTask;

    public ScanPairEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public ScanTaskEntity getScanTask() {
        return scanTask;
    }

    public void setScanTask(ScanTaskEntity scanTask) {
        this.scanTask = scanTask;
    }
}
