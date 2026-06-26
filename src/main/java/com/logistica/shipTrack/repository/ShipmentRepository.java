package com.logistica.shipTrack.repository;

import com.logistica.shipTrack.model.Shipment;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{
    
    Optional<Shipment> findByTrackingNumber(String trackNumber);
    
    List<Shipment> findByCourierId(Long idCourier);
    
}
