package com.bijay.redis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bijay.redis.dtos.PeopleDTO;
import com.bijay.redis.services.PeopleService;

@RestController
@RequestMapping(value="/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping(value="/all")
	public List<PeopleDTO> findAllPeople(){
		return peopleService.findAll();
	}
	
	@GetMapping(value="/id")
	public PeopleDTO findPeopleById(@RequestBody PeopleDTO peopleRequest) {
		return peopleService.findById(peopleRequest.getId());
	}
	
	@PostMapping(value="/update")
	public PeopleDTO updatePeople(@RequestBody PeopleDTO peopleRequest) {
		return peopleService.savePeople(peopleRequest);
	}
	
	@PostMapping(value="/flush")
	public void fushCache() {
		peopleService.flushCache();
	}

}
