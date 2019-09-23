package com.example.demo.security;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AppUserRepository;
import com.example.demo.model.AppUser;

import org.springframework.security.core.userdetails.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepository repository;

	public UserDetailsServiceImpl(AppUserRepository repository) {
		this.repository=repository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final Iterable<AppUser> users = repository.getall();

		for (AppUser appUser : users) {
			if (appUser.getUsername().equals(username)) {
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
						.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());
				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
			}
		}
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

	
}
