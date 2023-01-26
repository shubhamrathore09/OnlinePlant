package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.*;
import com.masai.exception.*;
import com.masai.model.Seed;

@RestController
@RequestMapping("/seed")
public class SeedController {

	
	@Autowired
	private SeedService seedServices;
	
	@GetMapping("/id/{id}/{key}")
	public ResponseEntity<Seed> getSeedById(@PathVariable("id") Integer id,@PathVariable("key") String key) throws SeedException, AdminLoginException{
		
		Seed seed=seedServices.viewSeed(id,key);
		
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
		
	}
	
	@GetMapping("/seeds/{key}")
	public ResponseEntity<List<Seed>> getAllSeed(@PathVariable("key")String key) throws SeedException, AdminLoginException{
		
		List<Seed> list=seedServices.viewAllSeeds(key);
		
		return new ResponseEntity<List<Seed>>(list,HttpStatus.OK);
		
	}

	

	
	@GetMapping("/name/{name}/{key}")
	public ResponseEntity<Seed> byName(@PathVariable("name") String name,@PathVariable("key") String key) throws SeedException, AdminLoginException{
		
	
		Seed seed=seedServices.viewSeed(name,key);
	
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	
	}
	
	@GetMapping("/type/{type}/{key}")
	public ResponseEntity<List<Seed>>byType(@PathVariable("type") String name, @PathVariable("key") String key) throws SeedException, AdminLoginException{
		
		List<Seed> seed=seedServices.viewAllSeeds(name,key);
		
		return new ResponseEntity<List<Seed>>(seed,HttpStatus.OK);
		
	}
	
}
