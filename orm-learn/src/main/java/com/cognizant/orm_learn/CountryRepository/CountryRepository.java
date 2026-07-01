package com.cognizant.orm_learn.CountryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<com.cognizant.orm_learn.model.Country.Country, String> {

}
