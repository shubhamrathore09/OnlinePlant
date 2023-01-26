package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Plant;

public interface PlantDao extends JpaRepository<Plant, Integer>{
	
    public Plant findByCommonName(String name);

    public List<Plant> findByTypeOfPlant(String type);

}
