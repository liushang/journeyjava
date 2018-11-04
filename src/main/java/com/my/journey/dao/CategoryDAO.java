package com.my.journey.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.journey.entity.Category;

public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
