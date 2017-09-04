package ua.kiev.inspector_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.UserDao;
import ua.kiev.inspector.model.entity.User;
import ua.kiev.inspector_api.model.UserPrincipalModel;

@Service
@Transactional
public class InspectorUserDetailsService implements UserDetailsService {
	
	@Autowired
	private DaoFactory daoFactory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDao userDao = daoFactory.createuUserDao();
		User user = userDao.findByUserName(username);
		
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		
		return new UserPrincipalModel(user);
	}

}
