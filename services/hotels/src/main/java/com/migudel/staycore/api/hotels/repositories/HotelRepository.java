package com.migudel.staycore.api.hotels.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.migudel.staycore.api.hotels.models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findAllByManagerId(Integer managerId);
}
