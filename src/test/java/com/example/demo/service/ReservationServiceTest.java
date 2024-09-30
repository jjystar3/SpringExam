package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;

@SpringBootTest
public class ReservationServiceTest {

	@Autowired
	ReservationService service;
	
	@Test
	public void 예약정보등록() {
		String string = "2023-09-10";
		LocalDate date = LocalDate.parse(string, DateTimeFormatter.ISO_DATE);
		ReservationDTO dto = ReservationDTO.builder()
						.checkInDate(date).guestName("홍길동").roomNo(205).guestPhone("010-3733-4444")
						.build();
		service.register(dto);
	}

	@Test
	public void 예약정보목록조회() {
		List<ReservationDTO> list = service.getList();
		for(ReservationDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 예약정보단건조회() {
		ReservationDTO dto = service.read(1);
		System.out.println(dto);
	}
}
