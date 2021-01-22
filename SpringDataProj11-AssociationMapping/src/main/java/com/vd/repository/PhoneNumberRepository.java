package com.vd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vd.entity.PhoneNumber;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
	
}
