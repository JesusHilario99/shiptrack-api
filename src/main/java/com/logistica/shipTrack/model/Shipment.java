package com.logistica.shipTrack.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "shipment")
@Data
@NoArgsConstructor
public class Shipment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String destinationAddress;
    private double weight;
    @Column(length = 20)
    private String trackingNumber;
    @Column(length = 20,nullable = false)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "courier_id",nullable = true)
    private Courier courier;

    public Shipment(String destinationAddress, double weight, String trackNumber) {
        this.destinationAddress = destinationAddress;
        this.weight = weight;
        this.trackingNumber = trackNumber;
        this.status = "PENDING";
        this.courier = null;
    }
    
    
    
    
}
