package com.mlreceipt.scanner.common.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ScanItems")
public class ScanItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String uuid;

    @ManyToOne
    @JsonBackReference("scanpair-scanitem")
    ScanPairEntity scanPair;
    String text;
    int probability;

    public ScanItemEntity()
    {

    }

    public ScanItemEntity( String text, int probability) {
        this.uuid= UUID.randomUUID().toString();
        this.text = text;
        this.probability = probability;
    }

    public ScanPairEntity getScanPair() {
        return scanPair;
    }

    public void setScanPair(ScanPairEntity scanPair) {
        this.scanPair = scanPair;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}

