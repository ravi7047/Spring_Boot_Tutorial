package com.nareshit.transactionmgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.transactionmgmt.model.Insurance;

@Repository
public interface InsuranceDao extends CrudRepository<Insurance, Integer>{

}
