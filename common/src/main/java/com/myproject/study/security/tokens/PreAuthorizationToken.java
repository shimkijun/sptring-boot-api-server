package com.myproject.study.security.tokens;

import com.myproject.study.model.network.request.AccountApiRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PreAuthorizationToken(String username, String password){
        super(username,password);
    }

    public PreAuthorizationToken(AccountApiRequest request){
        this(request.getUserId(),request.getPassword());
    }

    public String getUsername(){
        return (String)super.getPrincipal();
    }

    public String getUserPassword(){
        return (String)super.getCredentials();
    }
}
