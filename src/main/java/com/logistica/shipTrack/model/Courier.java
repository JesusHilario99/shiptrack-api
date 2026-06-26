package com.logistica.shipTrack.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courier")
@Data
@NoArgsConstructor
public class Courier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 100)
    private String vehicleType;
    @Column(length = 15)
    private String plate;
    private int capacityMax;
    private int assignedShipments;

    public Courier(String name, String vehicleType, String plate, int capacityMax) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.plate = plate;
        this.capacityMax = capacityMax;
        this.assignedShipments = 0;
    }
}
