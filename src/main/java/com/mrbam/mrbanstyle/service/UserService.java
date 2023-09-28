package com.mrbam.mrbanstyle.service;


import com.mrbam.mrbanstyle.model.User;


public interface  UserService {

	//lista de users
	Iterable<User> findAll();
	
	//retorno o user que busco por id
	User findbyId(Long id);
	
	//adicionar o usuario passado
	void insert(User user);
	
	//escolhe user por id, e passo as informações novas
	void updateUser(Long id, User user);
	
	//deleta por id
	void delet(Long id);
}
