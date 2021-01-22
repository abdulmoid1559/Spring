package com.vd.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService {
	@Override
	public Set<String> showCountries() {
		Set<String> list=new TreeSet();
		Locale [] locale=Locale.getAvailableLocales();
		for(Locale l:locale) {
			if(!l.getDisplayCountry().equals("")) 
				list.add(l.getDisplayCountry());
		}
		return list;
	}
}
