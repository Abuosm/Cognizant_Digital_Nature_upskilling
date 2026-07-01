package com.cognizant.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employee.dao.CountryDao;
import com.cognizant.employee.model.Country;

@Service
public class CountryService {

    @Autowired
    private CountryDao dao;

    public List<Country> getAllCountries() {
        return dao.getAllCountries();
    }

    public Country addCountry(Country country) {
        return dao.addCountry(country);
    }

}