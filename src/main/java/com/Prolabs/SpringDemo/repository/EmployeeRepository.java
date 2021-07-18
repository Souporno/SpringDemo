package com.Prolabs.SpringDemo.repository;

import com.Prolabs.SpringDemo.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

}
