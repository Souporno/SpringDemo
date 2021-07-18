package com.Prolabs.SpringDemo.repository;

import com.Prolabs.SpringDemo.entity.AddressEntity;
import com.Prolabs.SpringDemo.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<AddressEntity, Integer> {
    public List<AddressEntity> findByState(String value);
    public List<AddressEntity> findByPin(String value);
    public List<AddressEntity> findByCity(String value);
}
