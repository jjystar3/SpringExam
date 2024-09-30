package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {

	List<ReservationDTO> getList();
	
	void register(ReservationDTO dto);

	ReservationDTO read(int no);
	
	default Reservation dtoToEntity(ReservationDTO dto) {
		
		Reservation entity = Reservation.builder()
				.no(dto.getNo())
				.checkInDate(dto.getCheckInDate())
				.guestName(dto.getGuestName())
				.guestPhone(dto.getGuestPhone())
				.roomNo(dto.getRoomNo())
				.build();
		return entity;
	}
	
	default ReservationDTO entityToDTO(Reservation entity) {

		ReservationDTO dto = ReservationDTO.builder()
				.no(entity.getNo())
				.checkInDate(entity.getCheckInDate())
				.guestName(entity.getGuestName())
				.guestPhone(entity.getGuestPhone())
				.roomNo(entity.getRoomNo())
				.build();

		return dto;
	}
}
