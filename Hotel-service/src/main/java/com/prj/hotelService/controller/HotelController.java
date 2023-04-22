package com.prj.hotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.hotelService.entities.Hotel;
import com.prj.hotelService.services.impl.HotelServiceImpl;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;

	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
		Hotel create = hotelServiceImpl.create(hotel);

		return new ResponseEntity<>(create, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {

		List<Hotel> allHotel = hotelServiceImpl.getAllHotel();
		return ResponseEntity.status(HttpStatus.OK).body(allHotel);
	}

	@GetMapping("/{id}")
	public Hotel getHotel(@PathVariable String id) {

		Hotel hotel = hotelServiceImpl.getHotel(id);
		return hotel;
	}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable String hotelId) {

		hotelServiceImpl.deleteHotel(hotelId);

		return ResponseEntity.status(HttpStatus.OK).body("Hotel Deleted by ID : " + hotelId);

	}

	@PutMapping
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {

		Hotel updateHote = hotelServiceImpl.updateHotel(hotel);

		return ResponseEntity.status(HttpStatus.OK).body(updateHote);

	}

}
