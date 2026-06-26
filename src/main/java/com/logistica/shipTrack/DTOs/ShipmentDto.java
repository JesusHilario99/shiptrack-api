package com.logistica.shipTrack.DTOs;

import com.logistica.shipTrack.model.Courier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDto {
    
    private String destinationAddress;
    private double weight;
    
}
