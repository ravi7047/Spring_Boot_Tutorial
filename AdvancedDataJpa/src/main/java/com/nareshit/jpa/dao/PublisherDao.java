package com.nareshit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.jpa.model.Publisher;

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer>{

}
