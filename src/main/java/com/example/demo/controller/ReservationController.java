package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		List<ReservationDTO> list = service.getList();
		
		model.addAttribute("list", list);		
	}
	
}
