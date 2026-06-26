package com.logistica.shipTrack.controller;

import com.logistica.shipTrack.DTOs.ShipmentDto;
import com.logistica.shipTrack.DTOs.AssignCourierDto;
import com.logistica.shipTrack.model.Shipment;
import com.logistica.shipTrack.service.ShipmentService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    
    // endpoint para obetener todos los registros de la bd
    @GetMapping("/envios")
    public List<Shipment> getShipmentList(){
        return shipmentService.getShipmentsList();
    }
    
    //buscar por numero de rastreo
    @GetMapping("/envios/{numRastreo}")
    public Shipment getShipmentByNumberTrack(@PathVariable String numRastreo){
        return shipmentService.findByTrackNumber(numRastreo);
    }  
    
    
    //endpoint para agregar un envio
    @PostMapping("/envios")
    public Shipment addShipment(@RequestBody ShipmentDto data){
        return shipmentService.addShipment(data.getDestinationAddress(), data.getWeight());
    }
    
    // asignar un paquete a un repartidor
    @PutMapping("/envios/{idShipment}/repartidor")
    public Shipment assignCourier(@PathVariable Long idShipment, @RequestBody AssignCourierDto idCourier){
        return shipmentService.assignCourier(idShipment, idCourier.getCourierId());
    }
    
    
    
    
}
