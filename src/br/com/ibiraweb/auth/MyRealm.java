package br.com.ibiraweb.auth;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author Ankit
 * 
 */
public class MyRealm extends AuthorizingRealm {


    /**
     * 
     */
    public MyRealm() {
        super();
        /*
         * Set credential matcher on object creation
         */
        setCredentialsMatcher(new CredentialsMatcher() {

            public boolean doCredentialsMatch(AuthenticationToken arg0,
                    AuthenticationInfo arg1) {
                UsernamePasswordToken token = (UsernamePasswordToken) arg0;
                String username = token.getUsername();
                String password = new String(token.getPassword());
                /*
                    Check for credential and return true if found valid else false
                */
                return false;
            }
        });
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        Collection<String> permissionSet;
        SimpleAuthorizationInfo info = null;
        String userId = (String) principalCollection.getPrimaryPrincipal();

        //Using thi principle create  SimpleAuthorizationInfo and provide permissions and roles 
            info = new SimpleAuthorizationInfo();

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        
        
        /*using this token create a SimpleAuthenticationInfo like 
        User user = UserUtil.findByEmail(token.getUsername());
        */
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(), token.getPassword(), "screenName");

        
        
        Subject currentUser = null;
        currentUser = SecurityUtils.getSubject();
        
        Session session = currentUser.getSession();
        
        session.setAttribute				( "userRoles"		, "admin" 					);
        
        
        
        return authenticationInfo;
    }

}