package br.com.ibiraweb;


import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

        private static Logger logger = Logger.getLogger(MyRealm.class.getName());

        private MySecurityManagerService mySecurityManagerService;

        
        public MyRealm(MySecurityManagerService mySecurityManagerService) {
                // This is the thing that knows how to find user creds and roles
                this.mySecurityManagerService = mySecurityManagerService;
        }

        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(
                        PrincipalCollection principalCollection) {

                String username = (String) principalCollection.getPrimaryPrincipal();

                // Find the thing that stores your user's roles.
                MyPrincipal principal = mySecurityManagerService
                                .findMyPrincipalByUsername(username);
                
                
                
                if (principal == null) {
                        if (logger.isLoggable(Level.FINE)) {
                                logger.fine("Principal not found for authorizing user with username: "
                                                + username);
                        }
                        return null;
                } else {
                        if (logger.isLoggable(Level.FINE)) {
                                logger.fine(String.format(
                                                "Authoriziong user %s with roles: %s", username,
                                                principal.getRoles()));
                        }
                        SimpleAuthorizationInfo result = new SimpleAuthorizationInfo(
                                        principal.getRoles());
                        return result;
                }
        }

        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(
                        AuthenticationToken authenticationToken)
                        throws AuthenticationException {

                UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
                if (usernamePasswordToken.getUsername() == null
                                || usernamePasswordToken.getUsername().isEmpty()) {
                        throw new AuthenticationException("Authentication failed");
                }

                // Find the thing that stores your user's credentials. This may be the
                // same or different than
                // the thing that stores the roles.
                MyPrincipal principal = mySecurityManagerService.findMyPrincipalByUsername(usernamePasswordToken.getUsername());
                if (principal == null) {
                        if (logger.isLoggable(Level.FINE)) {
                                logger.fine("Principal not found for user with username: "
                                                + usernamePasswordToken.getUsername());
                        }
                        return null;
                }

                if (logger.isLoggable(Level.FINE)) {
                        logger.fine("Principal found for authenticating user with username: "
                                        + usernamePasswordToken.getUsername());
                }

                return new SimpleAccount(principal.getUsername(),
                                principal.getPassword(), getName(), principal.getRoles(),
                                new HashSet());
        }
        
        
 class        MySecurityManagerService{
	 
	 
	 protected MyPrincipal findMyPrincipalByUsername(String user){
		 
		 return new MyPrincipal();
	 }
	 
	 
 }
 
 
 
 class MyPrincipal{
	 
	 private String password = "juni1274";
	 private String username = "admin";
	 private Set<String> roles;
	 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
 }
 

}