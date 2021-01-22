package com.vd.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class LocaleServiceImpl implements LocaleService {

	@Override
	public Set getAllCountries() {
		Locale locale[]=null;
		Set<String> listLocale=new TreeSet();
		
		locale=Locale.getAvailableLocales();
		for(Locale l:locale) {
			if(!l.getDisplayCountry().equals("")) {
				listLocale.add(l.getDisplayCountry());
			}
		}
		return listLocale;
	}

	@Override
	public Set getAllLanguage() {
		Locale [] locale=null;
		Set<String> langs=null;
		
		langs=new TreeSet();
		locale=Locale.getAvailableLocales();
		for(Locale l:locale) {
			langs.add(l.getDisplayLanguage());
		}
		return langs;
	}

}
