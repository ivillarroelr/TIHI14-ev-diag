package com.ivillarroelr.TIHI14evdiag.service;

import com.ivillarroelr.TIHI14evdiag.model.Currency;

public interface ICurrencyService<Object> {
    Currency readByShortname(String shortname);
    String getSymbolByShortname(String shortname);
}
