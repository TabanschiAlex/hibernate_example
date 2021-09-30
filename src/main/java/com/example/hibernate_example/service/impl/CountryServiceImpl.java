package com.example.hibernate_example.service.impl;

import com.example.hibernate_example.Requests.CountryRequest;
import com.example.hibernate_example.model.Country;
import com.example.hibernate_example.repository.CountryRepository;
import com.example.hibernate_example.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public  CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Iterable<Country> getAll(Integer page, String sort) {
        /*Pageable pageable = PageRequest.of(page != null ? page : 1, 10, Sort.by(sort != null ? sort : "name"));*/
        return countryRepository.findAll();
    }

    public Optional<Country> getOne(Long id) {
        return countryRepository.findById(id);
    }

    public Country store(CountryRequest request) {
        return countryRepository.save(new Country(request.getName()));
    }

    public Country update(CountryRequest request, Long id) {
        Country data = countryRepository.findById(id).orElseThrow();
        data.setName(request.getName());

        return countryRepository.save(data);
    }

    public String delete(Long id) {
        countryRepository.deleteById(id);
        return "Successfully deleted";
    }
}
