package test.task.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.task.library.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @SuppressWarnings("unchecked")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.readByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) getAuthorities(user);
        return createUser(user, authorities);
    }

    public void signIn(User user) {
        if(user != null) {
            UserDetails userDetails = loadUserByUsername(user.getEmail());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private org.springframework.security.core.userdetails.User createUser(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return AuthorityUtils.createAuthorityList(user.getRole().toString());
    }
}
