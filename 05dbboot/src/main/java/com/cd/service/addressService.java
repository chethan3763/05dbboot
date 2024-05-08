package com.cd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import com.cd.entities.*;


@Component
public class addressService {
	@Autowired
	IAddressPersistence address;
	
	public List<address> getAddress(){
		 return address.findAll(); 
	}

	public address createAddress(address payload) {
		return address.save(payload);
	}
	
}
