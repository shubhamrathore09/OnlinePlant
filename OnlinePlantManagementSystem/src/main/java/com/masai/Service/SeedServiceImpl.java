package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.*;
import com.masai.exception.*;
import com.masai.model.*;

@Service
public class SeedServiceImpl implements SeedService{
	
	@Autowired
    private AdminSessionRepo adminrepo;
	
	@Autowired
	private SeedRepo seedRepo;
	
	@Autowired
	private CustomerSessionRepo customerRepo;
	
	@Override
	public Seed addSeed(Seed seed,String key) throws SeedException,AdminLoginException{
		// TODO Auto-generated method stub
		
		AdminCurrentUserSession adminuser=adminrepo.findByAdminUuid(key);
		
		if(adminuser==null) {
			
			throw new AdminLoginException("please login first");
		}
		else {
			
			Seed seed2=seedRepo.findByCommanName(seed.getCommanName());
			
			if(seed2==null) {
			
			Seed saved =seedRepo.save(seed);
			
			return saved;
			}
			
			else {
				throw new SeedException("seed already available by that name");
			}
		}
			
	}

	@Override
	public Seed updateSeed(Seed seed,String key) throws SeedException,AdminLoginException{

		AdminCurrentUserSession adminUser=adminrepo.findByAdminUuid(key);
		
		if(adminUser==null) {
			
			throw new AdminLoginException("admin details not matched");
		}
		else {
			
			Seed seed2=seedRepo.findByCommanName(seed.getCommanName());
			
			if(seed2!=null) {
				
				return seedRepo.save(seed);
				
			}else {
				
				throw new SeedException("invalid seed details");
			}
		}
		
		
	}
	@Override
	public Seed deleteSeed(Integer id,String key)throws SeedException,AdminLoginException{
		
		AdminCurrentUserSession adminuser=adminrepo.findByAdminUuid(key);
		
		if(adminuser==null) {
			
			throw new AdminLoginException("admin not found");
			
		}
		else {
			
			Optional<Seed> opt=seedRepo.findById(id);
			
			if(opt.isPresent()) {
				
				Seed seedAvailable=opt.get();
				seedRepo.delete(seedAvailable);
				return seedAvailable;
				
			}
			else
				
			throw new SeedException("Seed not available by that id : "+id);
		}
		

	}

	@Override
	public Seed viewSeed(Integer id,String Key) throws SeedException,AdminLoginException{
		
		CustomerCurrentUserSession currentCustomer=customerRepo.findByCustomerUuid(Key);
		
		if(currentCustomer==null) {
			
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(Key);
			
			if(admin1==null) {
				throw new AdminLoginException("user not found ");
				
			}
			
			Optional<Seed> opt=seedRepo.findById(id);
			if(opt.isPresent()) {
				Seed seed=opt.get();
				return seed;
			}	
			throw new SeedException("seed not found by that "+id);
			
		}
			Optional<Seed> opt=seedRepo.findById(id);
			if(opt.isPresent()) {
				Seed seed=opt.get();
				return seed;
			}	
			throw new SeedException("seed not found by that "+id);
		}

	
	
	@Override
	public Seed viewSeed(String commanName,String key) throws SeedException, AdminLoginException {
		
		CustomerCurrentUserSession currentCustomer=customerRepo.findByCustomerUuid(key);
		
		if(currentCustomer==null) {
			
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(key);
			
			if(admin1==null) {
				
				throw new AdminLoginException("user not found ");
				
			}
			
			Seed seed=seedRepo.findByCommanName(commanName);
			
			if(seed==null) {
				throw new SeedException("Please enter valid seed name");
			}
			return seed;
			
		}
		Seed seed=seedRepo.findByCommanName(commanName);
		
		if(seed==null) {
			throw new SeedException("Please enter valid seed name");
		}
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds(String key) throws SeedException,AdminLoginException {
		
	CustomerCurrentUserSession currentCustomer=customerRepo.findByCustomerUuid(key);
		
		if(currentCustomer==null) {
			
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(key);
			
			if(admin1==null) {
				
				throw new AdminLoginException("user not found ");
				
			}
			
			List<Seed> seed=seedRepo.findAll();
			
			if(seed==null) {
				throw new SeedException("Please enter valid seed name");
			}
			return seed;
			
		}
		List<Seed> seed=seedRepo.findAll();
		
		if(seed==null) {
			throw new SeedException("Please enter valid seed name");
		}
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds(String TypeOfSeed, String key) throws SeedException, AdminLoginException{
		
		
       CustomerCurrentUserSession currentCustomer=customerRepo.findByCustomerUuid(key);
		
		if(currentCustomer==null) {
			
			AdminCurrentUserSession admin1=adminrepo.findByAdminUuid(key);
			
			if(admin1==null) {
				
				throw new AdminLoginException("user not found ");
				
			}
			
			List<Seed> seed=seedRepo.findByTypeOfSeed(TypeOfSeed);
			
			if(seed==null) {
				throw new SeedException("Please enter valid seed name");
			}
			return seed;
			
		}
		List<Seed> seed=seedRepo.findByTypeOfSeed(TypeOfSeed);
		
		if(seed==null) {
			throw new SeedException("Please enter valid seed name");
		}
		return seed;	
		
	}


}
