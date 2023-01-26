package com.masai.Service;

import java.util.List;

import com.masai.exception.AdminLoginException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlantException;
import com.masai.exception.PlanterNotFoundException;
import com.masai.model.Plant;

public interface PlantService {
	
	 public Plant addPlant(Plant plant, String key) throws AdminLoginException;

	    public Plant updatePlant(Plant plant,String key) throws PlantException,AdminLoginException;

	    public Plant deletePlantById(Integer plantId,String key) throws PlantException,AdminLoginException;

	    public Plant viewPlantById(Integer plantId, String uuid) throws PlantException, CustomerException, PlanterNotFoundException;

	    public Plant viewPlantByName(String name) throws PlantException;

	    public List<Plant> viewAllPlants() throws PlantException;

	    public List<Plant> viewPlantsByPlantType(String type) throws PlantException;
	    
	    

}
