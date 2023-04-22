package com.prj.hotelService.services;

import java.util.List;

import com.prj.hotelService.entities.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);

	List<Hotel> getAllHotel();

	Hotel getHotel(String hotelId);

	void deleteHotel(String hotelId);

	Hotel updateHotel(Hotel hotel);

}
