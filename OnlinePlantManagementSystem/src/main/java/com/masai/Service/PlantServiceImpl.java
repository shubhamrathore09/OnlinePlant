package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.*;
import com.masai.exception.*;
import com.masai.model.*;
import com.masai.model.*;

@Service
public class PlantServiceImpl implements PlantService{
	

	@Autowired
	private PlantDao pdao;

	@Autowired
	private AdminSessionRepo adminSessionRepo;
	
	@Autowired
	private CustomerSessionRepo cRepo;
	
	

	@Override
	public Plant addPlant(Plant plant, String key) throws AdminLoginException {

		AdminCurrentUserSession adminCurrentUserSession= adminSessionRepo.findByAdminUuid(key);

		if(adminCurrentUserSession!=null){
			
			Plant plants=pdao.save(plant);
			
			return plants;
			
		}
		else{
			
			throw new AdminLoginException("Login first...");
			
		}
	}

	@Override
	public Plant updatePlant(Plant plant, String key) throws PlantException,AdminLoginException {

		AdminCurrentUserSession adminCurrentUserSession= adminSessionRepo.findByAdminUuid(key);
		if(adminCurrentUserSession!=null){
			Optional<Plant> opt = pdao.findById(plant.getPlantId());

			if (opt.isPresent()) {

				return pdao.save(plant);

			} else {
				throw new PlantException("No plant found with this Plant Id :");
			}
		}else{
			throw new AdminLoginException(" Please Login first...");
		}

	}

	@Override
	public Plant deletePlantById(Integer plantId, String key) throws PlantException,AdminLoginException {


		AdminCurrentUserSession adminCurrentUserSession= adminSessionRepo.findByAdminUuid(key);
		if(adminCurrentUserSession!=null){
			Optional<Plant> opt = pdao.findById(plantId);

			if (opt.isPresent()) {
				Plant plant = opt.get();
				pdao.delete(plant);
				return plant;
			} else {
				throw new PlantException("No plant present with this Plant Id :"+plantId);
			}
		}else{
			throw new AdminLoginException("Please Login first...");
		}


	}

	@Override
	public Plant viewPlantById(Integer plantId,String uuid) throws PlantException, CustomerException, PlanterNotFoundException {
		
           AdminCurrentUserSession admin = adminSessionRepo.findByAdminUuid(uuid);
		
		if(admin==null) {
			
			CustomerCurrentUserSession customer = cRepo.findByCustomerUuid(uuid);
			
			if(customer==null) {
				
				throw new CustomerException("Please provide valid key");
				
			}else {
				
				Optional<Plant> optional = pdao.findById(plantId);
				
				if(optional.isPresent()) {
					
					Plant plant = optional.get();
					
					return plant;
					
				}else
					
					throw new PlanterNotFoundException("No plant is found with id :"+plantId);
			}
				
				
		}
		
		Optional<Plant> plant = pdao.findById(plantId);

		if (plant.isPresent()) {

			return plant.get();

		} else {
			
			throw new PlantException("Plant does not exist with this Plant Id :"+plantId);
		}

		
	}

	@Override
	public Plant viewPlantByName(String name) throws PlantException {
		Plant list = pdao.findByCommonName(name);

		if (list==null) {

			throw new PlantException("Plant does not exist with this Name :"+name);
		} else {
			return list;
		}
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantException {
		List<Plant> list = pdao.findAll();

		if (list.isEmpty()) {
			throw new PlantException("No plant found...");
		} else {
			return list;
		}
	}

	@Override
	public List<Plant> viewPlantsByPlantType(String type) throws PlantException {
		List<Plant> list = pdao.findByTypeOfPlant(type);

		if (list.isEmpty()) {

			throw new PlantException("No Plants exist with Plant Type :"+type);
		} else {

			return list;
		}
	}


}
