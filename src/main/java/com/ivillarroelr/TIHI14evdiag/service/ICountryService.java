package com.ivillarroelr.TIHI14evdiag.service;

import com.ivillarroelr.TIHI14evdiag.model.Country;

public interface ICountryService<Object> {
    Country readByShortname(String shortname);
}
