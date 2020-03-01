package com.myproject.study.security.tokens;

import com.myproject.study.model.enumclass.SocialProviders;
import com.myproject.study.model.network.request.AccountApiRequest;
import com.myproject.study.model.network.response.SocialLoginResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PreAuthorizationToken(String username, String password){
        super(username,password);
    }

    public PreAuthorizationToken(AccountApiRequest request){
        this(request.getUserId(),request.getPassword());
    }

    private PreAuthorizationToken(SocialProviders providers,SocialLoginResponse res){
    super(providers,res);
    }

    public PreAuthorizationToken(SocialLoginResponse res){
        this(res.getProviders(),res);
    }

    public String getUsername(){
        return (String)super.getPrincipal();
    }

    public String getUserPassword(){
        return (String)super.getCredentials();
    }
}
