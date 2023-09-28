package com.mrbam.mrbanstyle.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrbam.mrbanstyle.model.Endereco;
import com.mrbam.mrbanstyle.model.User;
import com.mrbam.mrbanstyle.repository.EnderecoRepository;
import com.mrbam.mrbanstyle.repository.UserRepository;
import com.mrbam.mrbanstyle.service.UserService;
import com.mrbam.mrbanstyle.service.ViaCepService;

//implementação da classe userService

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.
	
	@Autowired
	private ViaCepService viaCepService;
	
	
	@Override
	public Iterable<User> findAll() {
		// Buscar todos os Clientes.
		return userRepository.findAll();
	}
	

	@Override
	public User findbyId(Long id) {
		 Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	@Override
	public void insert(User user) {
		saveUserCep(user);
	}
		

	@Override
	public void updateUser(Long id, User user) {
		// Buscar User por ID, caso exista:
		Optional<User> users = userRepository.findById(id);
		if (users.isPresent()) {
			saveUserCep(user);
		}
	}

	@Override
	public void delet(Long id) {
		userRepository.deleteById(id);
	}
	
	private void saveUserCep(User user) {
		String cep = user.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(()->{
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		user.setEndereco(endereco);
		userRepository.save(user);
	}

}

