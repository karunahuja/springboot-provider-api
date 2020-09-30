package com.api.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.springrest.entities.Provider;
import com.api.springrest.services.ProviderService;


@RestController
public class ProviderController {


	
	@Autowired
	private ProviderService providerService;
	
	
	
	//Get all Providers
	
	@GetMapping("/providers")
	public ResponseEntity<List<Provider>> getProviders() {
		
		
		List<Provider> list= this.providerService.getAllProviders();
		
		if(list.size()<=0) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
		
	
	}
	
	//Get single provider

	
	@GetMapping("/providers/{id}")
	public ResponseEntity<Optional<Provider>> getProvider(@PathVariable("id") int id)
	{
		 
		Optional<Provider> provider=providerService.getProviderById(id);
		if(provider==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.of(Optional.of(provider));
	}
	
	
	
	//add new provider
	
	@PostMapping("/providers")
	public ResponseEntity<Provider> addProvider(@RequestBody Provider provider) {
		Provider b=null;
		
		try {
			b=this.providerService.addProvider(provider);
			System.out.println(provider);
			return ResponseEntity.of(Optional.of(b));
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			
		}
		
	
	}
	
	//delete Provider
	
	
	@DeleteMapping("/providers/{providerId}")
	public ResponseEntity<Void> deleteProvider(@PathVariable("providerId") int providerId) {
		
		try {
			
			this.providerService.deleteProvider(providerId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
		
		
		
	}
	
	//update
	@PutMapping("/providers/{providerId}")
	public ResponseEntity<Provider> updateProvider(@RequestBody Provider provider,@PathVariable("providerId") int providerId) {
	
		try {
			this.providerService.updateProvider(provider, providerId);
	return ResponseEntity.ok().body(provider);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	
}
