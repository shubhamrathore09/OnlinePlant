package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.*;
import com.masai.exception.*;
import com.masai.model.*;

@Service
public class PlanterServiceImpl implements PlanterService{
	
	@Autowired
	private PlanterRepo planterDao;
	
	@Autowired
	private AdminSessionRepo loginDao;
	
	@Autowired
	private CustomerSessionRepo customerLogin;
	
	@Autowired
	private PlantDao plantDao;
	
	@Autowired
	private SeedRepo seedRepo;

	@Override
	public Planter addPlanter(String uuid, Planter planter) throws PlanterNotFoundException, AdminException{
		
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
	
		
		Planter saved = planterDao.save(planter);

		return saved;
	}

	@Override
	public Planter updatePlanter(String uuid, Planter planter) throws PlanterNotFoundException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		Optional<Planter> opt = planterDao.findById(planter.getPlanterId());
		Planter updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			updated=planter;
			return planterDao.save(updated);
		}else {
			throw new PlanterNotFoundException("Planter not found with id : "+planter.getPlanterId());
		}
	}

	@Override
	public Planter deletePlanter(String uuid, Integer planterId) throws PlanterNotFoundException, AdminException {
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		
		if(admin==null) {
			throw new AdminException("Please Login as Admin");
		}
		
		Optional<Planter> opt = planterDao.findById(planterId);
		Planter updated = null;
		if(opt.isPresent()) {
			updated=opt.get();
			planterDao.delete(updated);
			return updated;
		}else {
			throw new PlanterNotFoundException("Planter not found with id : "+planterId);
		}
	}
	
	@Override
	public Planter viewPlanter(String uuid, Integer planterId) throws PlanterNotFoundException ,CustomerException{
		
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		
		if(admin==null) {
			
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			
			if(customer==null) {
				
				throw new CustomerException("Please provide valid key");
			}else {
				
				Optional<Planter> optional = planterDao.findById(planterId);
				
				if(optional.isPresent()) {
					
					Planter planter = optional.get();
					
					return planter;
					
				}else
					
					throw new PlanterNotFoundException("No planter is found with id :"+planterId);
			}
				
				
		}
		Optional<Planter> opt =planterDao.findById(planterId);
		
		Planter updated = null;
		
		if(opt.isPresent()) {
			
			updated=opt.get();
			
			return updated;
			
		}else {
			
			throw new PlanterNotFoundException("Planter not found with Id : "+planterId);
		}
	}
	
	@Override
	public List<Planter> viewPlanterByShape(String uuid, String planterShape) throws PlanterNotFoundException,CustomerException {
		
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		
		if(admin==null) {
			
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			
			if(customer==null) {
				
				throw new CustomerException("Please provide valid key");
			}else {
				
				List<Planter> planters = planterDao.findByPlanterShape(planterShape);
				
				if(planters.isEmpty()) {
					
					throw new PlanterNotFoundException("Planter not found with shape : "+planterShape);
					
				}else {
					
					return planters;
				}
					
					
			}
		}
		
		List<Planter> planters =planterDao.findByPlanterShape(planterShape);
		
		if(planters.isEmpty()) {
			
			throw new PlanterNotFoundException("Planter not found with shape : "+planterShape);
			
			
		}else {
			
			return planters;
			
		}
		
	}

	@Override
	public List<Planter> viewAllPlanters(String uuid) throws PlanterNotFoundException ,CustomerException{
		
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		
		if(admin==null) {
			
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			
			if(customer==null) {
				
				throw new CustomerException("Please provide valid key");
			}else {
				
				List<Planter> planters = planterDao.findAll();
				
				if(planters.isEmpty()) {
					
					throw new PlanterNotFoundException("No planter is available");
					
				}else {
					
					return planters;
				}
					
					
			}
		}
		List<Planter> list = planterDao.findAll();
		
		if(list.size()==0) {
			
			throw new PlanterNotFoundException("There are no planters available");
		}
		return list;
	}

	@Override
	public List<Planter> viewAllPlanters(String uuid,Double minCost, Double maxCost) throws PlanterNotFoundException,CustomerException {
		
		AdminCurrentUserSession admin = loginDao.findByAdminUuid(uuid);
		
		if(admin==null) {
		
			CustomerCurrentUserSession customer = customerLogin.findByCustomerUuid(uuid);
			
			if(customer==null) {
				
				throw new CustomerException("Please provide valid key");
			}else {
				
				List<Planter> planters = planterDao.findByPlanterBetweenMinAndMax(minCost, maxCost);
				
				if(planters.isEmpty()) {
					
					throw new PlanterNotFoundException("No planter is available in this range");
					
				}else {
					
					return planters;
				}
					
					
			}
		}
		
		List<Planter> list = planterDao.findByPlanterBetweenMinAndMax(minCost,maxCost);
		
		if(list.size()==0) {
		
			throw new PlanterNotFoundException("No planter is available in this range");
		}
		return list;
	}
	
	

	@Override
	public String AssignPlantAndSeedToPlanter(Integer plantId, Integer SeedId, Integer planterId, String key) {
		
		Optional<Plant> plant=plantDao.findById(plantId);
		
		Optional<Seed> seed =seedRepo.findById(SeedId);
		
		Optional<Planter> planter=planterDao.findById(planterId);
		
		if(plant.isPresent() && seed.isPresent() && planter.isPresent()) {
			
			System.out.println("*************************************************************************************");
			
			
			
			Plant plant1=plant.get();
			
			Seed seed1=seed.get();
			
			
			planter.get().setPlant(plant1);
			
			planter.get().setSeed(seed1);
			
			planterDao.save(planter.get());
			return "assign succefully";
		}
		
		return null;
	}


}
