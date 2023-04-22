package com.prj.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.hotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String>{

}
