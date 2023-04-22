package com.prj.hotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.prj.hotelService.entities.Hotel;
import com.prj.hotelService.exceptions.ResourceNotFoundException;
import com.prj.hotelService.repositories.HotelRepository;
import com.prj.hotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	private final HotelRepository repository;

	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.repository = hotelRepository;
	}

	@Override
	public Hotel create(Hotel hotel) {

		UUID uuid = UUID.randomUUID();
		String randomHotelId = uuid.toString();
		hotel.setId(randomHotelId);

		Hotel save = repository.save(hotel);
		return save;
	}

	@Override
	public List<Hotel> getAllHotel() {

		List<Hotel> findAll = repository.findAll();
		return findAll;
	}

	@Override
	public Hotel getHotel(String hotelId) {

		Hotel hotelIs = repository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel is not found by given hotelId: " + hotelId));

		return hotelIs;
	}

	@Override
	public void deleteHotel(String hotelId) {
		repository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel is not found by given hotelId: " + hotelId));
		repository.deleteById(hotelId);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {

		repository.findById(hotel.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Hotel is not found by given hotelId: " + hotel.getId()));

		Hotel updateHotel = new Hotel();
		updateHotel.setId(hotel.getId());
		updateHotel.setName(hotel.getName());
		updateHotel.setLocation(hotel.getLocation());
		updateHotel.setAbout(hotel.getAbout());

		Hotel save = repository.save(updateHotel);

		return save;

	}

}
