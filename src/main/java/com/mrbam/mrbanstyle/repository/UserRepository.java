package com.mrbam.mrbanstyle.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mrbam.mrbanstyle.model.User;

//camada de repository

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
