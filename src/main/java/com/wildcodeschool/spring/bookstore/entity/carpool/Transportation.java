package com.wildcodeschool.spring.bookstore.entity.carpool;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.wildcodeschool.spring.bookstore.entity.Customer;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Transportation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime transportation_end;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime transportation_start;
	
	@ManyToOne
	private Customer passenger;
	
	@ManyToOne
	private Car car;

	

}
