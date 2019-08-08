package com.airsante.airmes.security;
import com.airsante.airmes.dao.AppRoleDAO;
import com.airsante.airmes.dao.AppUserDAO;
import com.airsante.airmes.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerome.vinet
 * @since 2019.03.28
 * Service qui récupère les informations de connexion et s'occupe de voir si l'utilisateur existe
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppRoleDAO appRoleDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(userName);
        if (appUser == null) {
            System.out.println("Utilisateur non trouvé! " + userName);
            throw new UsernameNotFoundException("Utilisateur " + userName + " n'a pas été trouvé dans la base de données");
        }
        System.out.println("Utilisateur trouvé : " + appUser);
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserName());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }
}

