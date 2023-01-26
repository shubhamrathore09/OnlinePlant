package com.masai.Service;

import java.util.List;

import com.masai.exception.*;
import com.masai.model.Cart;
import com.masai.model.ItemOrder;
import com.masai.model.Plant;
import com.masai.model.Planter;

public interface ItemOrderService {
	
public List<Planter> findSeedWithPlanter(String seed, String key) throws OrderException, CustomerException, PlanterNotFoundException;
	
	public List<Planter> findPlantWithPlanter(String plantName, String key) throws OrderException, CustomerException, PlanterNotFoundException;
	
	public String buyPlanterWithSeed(ItemOrder order, String key, Integer planterId) throws CustomerException,PlanterNotFoundException;
	
	public String buyPlanterWithPlant(ItemOrder order, String key, Integer planterId) throws CustomerException,PlanterNotFoundException;

	public String buyPlanterBYShapeAndId(ItemOrder order, String key, String shape, Integer planterId) throws CustomerException, PlanterNotFoundException;
	
	public Plant viewPlantByName(String key, String name) throws CustomerException, PlanterNotFoundException;
	
	public String buyPlantWithNameAndId(ItemOrder order, String name, Integer id, String key) throws CustomerException, PlanterNotFoundException;
	
	public String buySeedWithName(ItemOrder order, String name, String key) throws CustomerException, SeedException;
	
	public Cart viewCart(String key) throws OrderException;
	
	public String deleteItemFromCart(Integer bookingId, String key) throws OrderException, CustomerException;

}
