package com.learnwell.poc.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnwell.poc.dto.Countries;
import com.learnwell.poc.services.CountriesService;

/**
 * 
 * @author Korish Chella
 *
 */
@RestController
public class TestController {
	
	@Autowired
	CountriesService countriesServiceImpl;
	
	/**
	 * @author korish vara kumar
	 * @return test message
	 */
	@GetMapping("/test")
	public String test() {
		return "test api call";
	}
	
	@GetMapping("/demo/countries")
	public List<Countries> getDemoCountries() {
		return countriesServiceImpl.getDemoCountries();
	}
	
	@GetMapping("/")
    public String echoTheUsersEmailAddress(Principal principal) {
        return "login";
    }
}
