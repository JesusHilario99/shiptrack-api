package com.logistica.shipTrack.service;

import com.logistica.shipTrack.exception.TrackNumberNotFoundException;
import com.logistica.shipTrack.model.Courier;
import com.logistica.shipTrack.model.Shipment;
import com.logistica.shipTrack.repository.CourierRepository;
import com.logistica.shipTrack.repository.ShipmentRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final CourierRepository courierRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, CourierRepository courierRepository) {
        this.shipmentRepository = shipmentRepository;
        this.courierRepository = courierRepository;
    }

    //Listar la bd de los envios
    public List<Shipment> getShipmentsList() {
        return shipmentRepository.findAll();
    }

    // buscar por el numero de rastreo
    public Shipment findByTrackNumber(String trackNumber) {
        Shipment findShipment = shipmentRepository.findByTrackingNumber(trackNumber)
                .orElseThrow(() -> new TrackNumberNotFoundException("No existe el numero de rastreo no existe: " + trackNumber));
        return findShipment;
    }

    //Agregar un envio
    public Shipment addShipment(String destinationAddres, double weight) {
        UUID idAleatorio = UUID.randomUUID();
        String TrackNumber = idAleatorio.toString().substring(0, 8);
        Shipment newShipment = new Shipment(destinationAddres, weight, TrackNumber);
        return shipmentRepository.save(newShipment);
    }

    // asginar repartidor a envio
    public Shipment assignCourier(Long idShipment, Long idCourier) {
        Courier findCourier = courierRepository.findById(idCourier)
                .orElseThrow(() -> new IllegalArgumentException("No existe el repartidor con el id " + idCourier));
        Shipment findShipment = shipmentRepository.findById(idShipment)
                .orElseThrow(() -> new IllegalArgumentException("No existe el envio con el id " + idShipment));

        if (findCourier.getAssignedShipments() >= findCourier.getCapacityMax()) {
            throw new IllegalArgumentException("El repartidor ya no tiene espacio en su vehiculo");
        }

        findShipment.setCourier(findCourier);
        findShipment.setStatus("IN_TRANSIT");
        findCourier.setAssignedShipments(findCourier.getAssignedShipments()+1);

        return shipmentRepository.save(findShipment);

    }

}
