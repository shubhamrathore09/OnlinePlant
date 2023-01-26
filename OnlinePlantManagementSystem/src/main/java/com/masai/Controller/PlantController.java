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
@RequestMapping("/plant")
public class PlantController {
	
	 @Autowired
	    private PlantService pService;



	    // View plant by Plant Id

	    @GetMapping("/{id}/{key}")
	    public ResponseEntity<Plant> viewPlantByIdHandler(@PathVariable("id") Integer plantId, @PathVariable("key") String key) throws PlantException, CustomerException, PlanterNotFoundException {

	        Plant plant = pService.viewPlantById(plantId,key);

	        return new ResponseEntity<Plant>(plant, HttpStatus.OK);

	    }


	    // Find Plant by Plant name

	    @GetMapping("/name/{name}")
	    public ResponseEntity<Plant> viewPlantByPlantNameHandler(@PathVariable("name") String name)
	            throws PlantException {

	        Plant list = pService.viewPlantByName(name);

	        return new ResponseEntity<Plant>(list, HttpStatus.OK);

	    }


	    //	View all plants details

	    @GetMapping("/plants")
	    public ResponseEntity<List<Plant>> getAllPlantsHandler() throws PlantException {

	        List<Plant> plants = pService.viewAllPlants();

	        return new ResponseEntity<List<Plant>>(plants, HttpStatus.OK);
	    }

	    // View plants by plantType
	    @GetMapping("/type/{type}")
	    public ResponseEntity<List<Plant>> viewPlantsByPlantTypeHandler(@PathVariable("type") String type)
	            throws PlantException {

	        List<Plant> list = pService.viewPlantsByPlantType(type);

	        return new ResponseEntity<List<Plant>>(list, HttpStatus.OK);
	    }


}
