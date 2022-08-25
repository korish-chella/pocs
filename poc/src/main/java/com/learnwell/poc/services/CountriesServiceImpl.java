package com.learnwell.poc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnwell.poc.dao.CustomerRepository;
import com.learnwell.poc.dto.Countries;

@Service
public class CountriesServiceImpl implements CountriesService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Countries> getDemoCountries() {
		Countries countries = new Countries();
		countries.setId(101);
		countries.setName("korish");
		Countries countries2 = new Countries();
		countries2.setId(102);
		countries2.setName("ram charan");
		customerRepository.save(countries);
		customerRepository.save(countries2);
		return customerRepository.findAll();
	}

}
