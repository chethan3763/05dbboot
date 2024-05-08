package com.cd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cd.entities.Vendor;

@RestController
public class VendorController {
	
	@Autowired
	com.cd.service.vendorService vendorService;
	
	
	//ES_GET_ENTITYSET  ABAP
	@RequestMapping("/vendor")
	public List<Vendor> getVendors(){

		return vendorService.readAllVendors();
		
	}
	
	//ES_GET_ENTITY  ABAP
	//@RequestMapping("/vendor/{vendorCode}")
	/*
	 * public Vendor getVendorbyid(@PathVariable("vendorCode") String code) { return
	 * vendorService.getSingleVendorById(code); }
	 */
	//ES_CREATE_ENTITY  ABAP
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		System.out.println(myPostBody);
		return vendorService.createVendor(myPostBody); 
	}
	//Test Using localhost:8080/vendor/search?company=SAP
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company){
		return vendorService.seachByCompanyName(company);
	}
	
	//Test Using localhost:8080/vendor/lookup/44
	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGST(@PathVariable("gstNo") String GSTNo){
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") Long  code) { 
		Optional<Vendor> searchResult = vendorService.getSingleVendor(code);
		if(!searchResult.isPresent()) {
			return new Vendor((long)0, "","","","","","", null);
			
		}
		return searchResult.get();
	}
	
	
	
	
	  @RequestMapping(method=RequestMethod.PUT, value="/vendor") 
	  public Vendor updateVendor(@RequestBody Vendor vendor) { 
		  return vendorService.changeVendor(vendor); 
		}
	 	
	  @RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
	  public String removeVendor(@PathVariable("id") Long Id){
		  return vendorService.deleteVendor(Id);
		  
	  }
	 
	 
}
