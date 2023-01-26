package com.masai.Controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.*;
import com.masai.exception.*;
import com.masai.model.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private ItemOrderService iService;
	
//	**************************************************ragistor************************************************

	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer c1) throws CustomerException{
		
		Customer customer = cService.registerCustomer(c1);
		
		return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
	
//	***********************************************login**************************************************
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody CustomerLoginDTO dto) throws CustomerException{
		
		String str = cService.loginCustomer(dto);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
//	***********************************************logout**************************************************
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String> logoutCustomer(@PathVariable("key") String key) throws CustomerException{
		
		String str = cService.logoutCustomer(key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
//	***********************************************updatecustomer**************************************************
	
	@PutMapping("/update/{key}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("key") String key) throws CustomerException{
		
		Customer updateCustomer = cService.upDateCustomer(customer, key);
		
		return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	}
	
//	***********************************************View Profile**************************************************
	
	@GetMapping("/profile/{id}")
	public ResponseEntity<Customer> viewProfile(@PathVariable("id") Integer id) throws CustomerException{
		
		Customer customer = cService.seeProfile(id);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
//	***********************************************Get Planter**************************************************

	
	@GetMapping("/planterseed/{seed}/{key}")
	public ResponseEntity<List<Planter>> getPlanterWithSeed(@PathVariable("seed") String seed, @PathVariable("key") String key) throws OrderException, CustomerException, PlanterNotFoundException{
		
		List<Planter> planters = iService.findSeedWithPlanter(seed, key);
		
		return new ResponseEntity<List<Planter>>(planters, HttpStatus.OK);
	}
	
//	***********************************************Buy Planter with seed**************************************************
	
	@PostMapping("/planterseed/buy/{planterId}/{key}")
	public ResponseEntity<String> buyPlanterWithSeed(@RequestBody ItemOrder order, @PathVariable("key") String key, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterNotFoundException{
		
		String str = iService.buyPlanterWithSeed(order, key, planterId);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);

	}
	
//	***********************************************Buy Planter By shape**************************************************
	
	@PutMapping("/plantershapeid/buy/{planterId}/{shape}/{key}")
	public ResponseEntity<String> buyPlanterBYShapeAndId(@RequestBody ItemOrder order, @PathVariable("key") String key, @PathVariable("shape") String shape, @PathVariable("planterId") Integer planterId) throws CustomerException, PlanterNotFoundException {
		
		String str = iService.buyPlanterBYShapeAndId(order, key, shape, planterId);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
		
	} 
	
//	***********************************************get plant by name**************************************************
	
	
	
	@GetMapping("plant/{name}/{key}")
	public ResponseEntity<Plant> viewPlantByCommonName(@PathVariable("key") String key, @PathVariable("name") String name) throws CustomerException, PlanterNotFoundException{
		
		Plant plants = iService.viewPlantByName(key, name);
		
		return new ResponseEntity<Plant>(plants, HttpStatus.OK);
	}
	
//	***********************************************Buy plant by name and id**************************************************
	
	@PostMapping("plant/buy/{name}/{id}/{key}")
	public ResponseEntity<String> buyPlantWithNameAndId(@RequestBody ItemOrder order, @PathVariable("name") String name, @PathVariable("id") Integer id, @PathVariable("key") String key) throws CustomerException, PlanterNotFoundException{
		
		String str = iService.buyPlantWithNameAndId(order, name, id, key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
//	***********************************************Buy seed with name**************************************************
	
	
	@PostMapping("/seedname/buy/{name}/{key}")
	public ResponseEntity<String> buySeedWithName(@RequestBody ItemOrder order, @PathVariable("name") String name, @PathVariable("key") String key) throws CustomerException, SeedException{
		
		String str = iService.buySeedWithName(order, name, key);
		
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}
	
	
	
//	*********************************************View card****************************************************
	
	
	@GetMapping("/cart/{key}")
	public ResponseEntity<Cart> viewCart(@PathVariable("key") String key) throws OrderException{
	
		Cart cart = iService.viewCart(key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	
	}
	
//	***********************************************Delete Iteam from card**************************************************
	
	@DeleteMapping("/cart/{bookingId}/{key}")
	public ResponseEntity<String> deleteItemFromCart(@PathVariable("bookingId") Integer bookingId, @PathVariable("key") String key) throws OrderException, CustomerException{
		
		String str = iService.deleteItemFromCart(bookingId, key);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	


}
