package ua.kiev.inspector_api.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ua.kiev.inspector.model.entity.User;

public class UserPrincipalModel implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;

	public UserPrincipalModel(User user) {
		this.user = user;
	}
	
	public int getUserId() {
		return user.getUsersId();
	}
	
	public String getFullName() {
		String fullName = user.getFirstName() + " " + user.getLastName();
		return fullName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authList = user.getUserRoles().stream()
				.map(userRole -> new SimpleGrantedAuthority(userRole.getRoleName().toString()))
				.collect(Collectors.toList()); 
		return authList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
