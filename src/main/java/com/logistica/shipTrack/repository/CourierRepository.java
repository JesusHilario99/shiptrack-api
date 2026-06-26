package com.logistica.shipTrack.repository;

import com.logistica.shipTrack.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long>{
    
}
