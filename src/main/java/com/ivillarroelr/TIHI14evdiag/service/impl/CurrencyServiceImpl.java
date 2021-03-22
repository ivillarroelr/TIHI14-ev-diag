package com.ivillarroelr.TIHI14evdiag.service.impl;

import com.ivillarroelr.TIHI14evdiag.model.Currency;
import com.ivillarroelr.TIHI14evdiag.repo.ICurrencyRepo;
import com.ivillarroelr.TIHI14evdiag.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements ICurrencyService<Currency> {

    @Autowired
    private ICurrencyRepo repo;
    @Override
    public Currency readByShortname(String shortname) {
        return repo.readByShortname(shortname);
    }

    @Override
    public String getSymbolByShortname(String shortname) {
        return repo.getSymbolByShortname(shortname);
    }
}
