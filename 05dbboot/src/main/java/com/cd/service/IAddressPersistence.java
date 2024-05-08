package com.cd.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cd.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long>{

}
