package com.ivillarroelr.TIHI14evdiag.service.impl;

import com.ivillarroelr.TIHI14evdiag.model.Country;
import com.ivillarroelr.TIHI14evdiag.repo.ICountryRepo;
import com.ivillarroelr.TIHI14evdiag.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements ICountryService<Country> {

    @Autowired
    private ICountryRepo repo;
    @Override
    public Country readByShortname(String shortname) {
        return repo.readByShortname(shortname);
    }
}
