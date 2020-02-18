package com.wildcodeschool.spring.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.spring.bookstore.entity.carpool.Car;
import com.wildcodeschool.spring.bookstore.repository.CarRepository;

@Controller
public class CarController {

	private final CarRepository carRepo;
	
	public CarController(CarRepository carRepo) {
		super();
		this.carRepo = carRepo;
	}

	@GetMapping("/cars")
	public String getAll(Model model) {
		model.addAttribute("cars", carRepo.findAll());
		return "car/get_all";
	}

	@PostMapping("/car/upsert")
	public String upsert(Car car) {
		car = carRepo.save(car);
		return "redirect:/cars";
	}

	@GetMapping("/car/{id}/delete")
	public String delete(@PathVariable Long id) {
		carRepo.deleteById(id);
		return "redirect:/cars";
	}

}
