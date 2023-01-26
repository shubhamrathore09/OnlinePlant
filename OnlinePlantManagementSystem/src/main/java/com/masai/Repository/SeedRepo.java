package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Planter;
import com.masai.model.Seed;

public interface SeedRepo extends JpaRepository<Seed, Integer>{

public Seed findByCommanName(String commanName);

public List<Seed> findByTypeOfSeed(String typeOfSeed);

}
