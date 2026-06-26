package com.logistica.shipTrack.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierDto {

    private String name;
    private String vehicleType;
    private String plate;
    private int capacityMax;
    
    
}
