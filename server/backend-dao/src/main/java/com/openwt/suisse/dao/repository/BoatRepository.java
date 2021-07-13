package com.openwt.suisse.dao.repository;

import com.openwt.suisse.dao.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {
}
