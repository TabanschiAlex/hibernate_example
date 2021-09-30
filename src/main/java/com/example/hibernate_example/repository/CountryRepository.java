package com.example.hibernate_example.repository;

import com.example.hibernate_example.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
