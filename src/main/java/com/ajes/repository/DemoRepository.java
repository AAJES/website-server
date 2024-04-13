package com.ajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajes.model.Demo;

public interface DemoRepository extends JpaRepository<Demo,Integer>{

}
