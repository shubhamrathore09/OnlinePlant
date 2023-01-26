package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.*;
import com.masai.exception.*;
import com.masai.model.*;

@RestController
@RequestMapping("/planter")
public class PlanterController {
	
	@Autowired
	private PlanterService pService;
	
	// View Planter By Id ----------------------------------------
	
	@GetMapping("/id/{planterId}/{loginId}")
	public ResponseEntity<Planter> getPlanterByIdHandler(@PathVariable("loginId")String uuid,@PathVariable Integer planterId) throws PlanterNotFoundException, AdminException, CustomerException{
		
		Planter planter = pService.viewPlanter(uuid,planterId);
		
		return new ResponseEntity<Planter>(planter,HttpStatus.OK);
	}
	
	// View All Planter By shape
	
	@GetMapping("/shape/{shape}/{loginId}")
	public ResponseEntity<List<Planter>> getPlanterByShapeHandler(@PathVariable("loginId")String uuid, @PathVariable("shape")String shape) throws PlanterNotFoundException, AdminException, CustomerException{
		
		List<Planter> planter = pService.viewPlanterByShape(uuid,shape);
		
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}
	
	// View All Planters
	
	@GetMapping("/planters/{key}")
	public ResponseEntity<List<Planter>> getPlantersHandler(@PathVariable("key") String uuid) throws PlanterNotFoundException, CustomerException{
		
		List<Planter> planters = pService.viewAllPlanters(uuid);
		
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	// View plant by setting price range
	
	@GetMapping("/range/{min}/{max}")
	public ResponseEntity<List<Planter>> getPlantersByCostRangeHandler(String uuid,@PathVariable("min")Double min,@PathVariable("max")Double max) throws PlanterNotFoundException, CustomerException{
		
		List<Planter> planter = pService.viewAllPlanters(uuid,min, max);
		
		return new ResponseEntity<List<Planter>>(planter,HttpStatus.OK);
	}

}
