package com.cognizant.orm_learn;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.orm_learn.model.Country.Country;
import com.cognizant.orm_learn.service.CountryService.CountryService;

@SpringBootTest
class OrmLearnApplicationTests {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplicationTests.class);

    @Autowired
    private CountryService countryService;

    @Test
    void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }
}