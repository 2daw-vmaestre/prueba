//package com.ejemplos.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.ejemplos.models.dao.IMedicoDao;
//import com.ejemplos.models.entity.Medico;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//	
//	@Autowired
//	private IMedicoDao medicoRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Medico medico= medicoRepo.findByNumeroIdentificacion(username);
//		
//		return new User(medico.getNumeroIdentificacion(),medico.getPass(),true,true,true,true,null);
//	}
//
//	
//	
//}
