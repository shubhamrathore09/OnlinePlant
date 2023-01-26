package com.masai.Service;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.CustomerException;
import com.masai.exception.PlanterNotFoundException;
import com.masai.model.Planter;

public interface PlanterService {
	

	public Planter addPlanter(String uuid,Planter planter) throws PlanterNotFoundException,AdminException;
	
	public Planter updatePlanter(String uuid,Planter planter) throws PlanterNotFoundException,AdminException;
	
	public Planter deletePlanter (String uuid,Integer planterId) throws PlanterNotFoundException,AdminException;
	
	public Planter viewPlanter(String uuid,Integer planterId) throws PlanterNotFoundException,CustomerException;
	
	public List<Planter> viewPlanterByShape(String uuid,String planterShape) throws PlanterNotFoundException,CustomerException;
	
	public List<Planter> viewAllPlanters(String uuid) throws PlanterNotFoundException,CustomerException;
	
	public List<Planter> viewAllPlanters(String uuid,Double minCost,Double maxCost) throws PlanterNotFoundException,CustomerException;
	
	public String  AssignPlantAndSeedToPlanter(Integer plantId,Integer SeedId,Integer planterId,String key);

}
