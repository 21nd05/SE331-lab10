package camt.se331.shoppingcart.config.security;

import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Family on 19/4/2559.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if (user == null){
            throw  new UsernameNotFoundException("User Name"+userName+"not found");
        }
        return new SecurityUser(user);
    }
}
