package com.logistica.shipTrack.service;

import com.logistica.shipTrack.model.Courier;
import com.logistica.shipTrack.model.Shipment;
import com.logistica.shipTrack.repository.CourierRepository;
import com.logistica.shipTrack.repository.ShipmentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourierService {
    
    private final CourierRepository courierRepository;
    private final ShipmentRepository shipmentRepository;

    public CourierService(CourierRepository courierRepository, ShipmentRepository shipmentRepository) {
        this.courierRepository = courierRepository;
        this.shipmentRepository = shipmentRepository;
    }
    
    
    // metodo para ver todos los datos de la bd courier
    public List<Courier> getCourierList(){
        return courierRepository.findAll();
    }
    
    
    // obtener repartidor por id
    public Courier getCourierById(Long id){
        return courierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no existe registro con el id "+id));
    }
    
    //obtener los envios asignados a un repartidor
    public List<Shipment> assignedShipments(Long idCourier){
        List<Shipment> listShipments = shipmentRepository.findByCourier_Id(idCourier);
        return listShipments;
    }
    
    
    // metodo para agregar un repartidor
    public Courier addCourier(String name, String vehicleType, String plate, int capacityMax){
        Courier newCourier = new Courier(name, vehicleType, plate,capacityMax);
        return courierRepository.save(newCourier);
    }
    
    
    //metodo para actualizar un repartidor
    public Courier updateCourier(String newName, String newVehicleType, String newPlate, int capacityMax, Long id){
         Courier updateCourier = courierRepository.findById(id)
                 .orElseThrow(()-> new IllegalArgumentException("No existe el registro con id : "+id));
         
         updateCourier.setName(newName);
         updateCourier.setVehicleType(newVehicleType);
         updateCourier.setPlate(newPlate);
         updateCourier.setCapacityMax(capacityMax);
         
         return courierRepository.save(updateCourier);
    }
    
    //metodo para eliminar un repartidot
    public String deleteCourier(Long id){
        if (!courierRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe el id proporcionado");
        }
        courierRepository.deleteById(id);
        return "Repartidor eliminado correctamente";
    }
    
    
    
}
