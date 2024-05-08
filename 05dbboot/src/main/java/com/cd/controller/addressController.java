package com.cd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cd.entities.address;
import com.cd.service.addressService;
import java.util.List;

@RestController
public class addressController {
	
	@Autowired 
	addressService addrSrv;  
	
	@RequestMapping("/addresses")
	public List<address> getAddress(){
		 return addrSrv.getAddress();
		 }

	@PostMapping("/addresses")
	public address createAddress(@RequestBody address payload) {
		return addrSrv.createAddress(payload);
	}

}
 
