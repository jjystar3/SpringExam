package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationRepositoryTest {

	@Autowired
	ReservationRepository repository;
	
	@Test
	void 예약정보등록() {
		Reservation reservation = Reservation.builder()
						.guestName("도우너").roomNo(201) //.guestPhone("010-3333-4444")
						.build();
		repository.save(reservation);
	}

	@Test
	void 예약정보목록조회() {
		List<Reservation> list = repository.findAll();
		for(Reservation reservation : list) {
			System.out.println(reservation);
		}
	}
	
	@Test
	void 예약정보단건조회() {
		Optional<Reservation> result = repository.findById(1);
		if(result.isPresent()) {
			Reservation reservation = result.get();
			System.out.println(reservation);
		}
	}
}
