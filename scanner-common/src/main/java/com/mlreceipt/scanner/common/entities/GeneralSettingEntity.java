package com.mlreceipt.scanner.common.entities;

import javax.persistence.*;

@Entity
@Table(name="GeneralSettings")
public class GeneralSettingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public int threshold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
