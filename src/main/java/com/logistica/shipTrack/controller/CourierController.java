package com.logistica.shipTrack.controller;

import com.logistica.shipTrack.DTOs.CourierDto;
import com.logistica.shipTrack.model.Courier;
import com.logistica.shipTrack.model.Shipment;
import com.logistica.shipTrack.service.CourierService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourierController {

    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    //Obtener lista de los repartidores
    @GetMapping("/repartidor")
    public List<Courier> getCouriers() {
        return courierService.getCourierList();
    }
    
    //Obtener por id
    @GetMapping("/repartidor/{id}")
    public Courier getCourierById(@PathVariable Long id){
        return courierService.getCourierById(id);
    }
    
    //listar los paquetes asignados a un repartidor
     @GetMapping("/repartidor/{idCourier}/envios")
     public List<Shipment> ShipmentList(@PathVariable Long idCourier){
         return courierService.assignedShipments(idCourier);
     }
    

    //Agregar a un repartidor
    @PostMapping("/repartidor")
    public Courier addCourier(@RequestBody CourierDto data) {
        return courierService.addCourier(data.getName(), data.getVehicleType(), data.getPlate(),data.getCapacityMax());
    }
    
    //Actualizar un repartidor
    @PutMapping("/repartidor/{id}")
    public Courier updateCourier(@PathVariable Long id, @RequestBody CourierDto data){
        return courierService.updateCourier(data.getName(), data.getVehicleType(), data.getPlate(), data.getCapacityMax() ,id);
    }
    
    @DeleteMapping("/repartidor/{id}")
    public String deleteCourier(@PathVariable Long id){
        return courierService.deleteCourier(id);
    }
    
    

}
