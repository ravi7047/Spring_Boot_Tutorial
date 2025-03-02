package com.nareshit.transactionmgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.transactionmgmt.model.Audit;

@Repository
public interface AuditDao extends CrudRepository<Audit, Integer>{

}
