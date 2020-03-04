package com.myproject.study.security.providers;

import com.myproject.study.model.entity.Account;
import com.myproject.study.model.enumclass.SocialProviders;
import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.network.response.SocialLoginResponse;
import com.myproject.study.security.AccountContext;
import com.myproject.study.security.repository.AccountRepository;
import com.myproject.study.security.service.specification.SocialFetchService;
import com.myproject.study.security.social.SocialUserProperty;
import com.myproject.study.security.tokens.PostAuthorizationToken;
import com.myproject.study.security.tokens.SocialPreAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SocialLoginAuthenticationProvider implements AuthenticationProvider {

    private final AccountRepository accountRepository;

    @Qualifier("socialFetchServiceProd")
    private final SocialFetchService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SocialPreAuthorizationToken token = (SocialPreAuthorizationToken)authentication;
        SocialLoginResponse res = token.getResponse();

        return PostAuthorizationToken.getTokenFromAccountContext(AccountContext.fromAccountModel(getAccount(res)));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SocialPreAuthorizationToken.class.isAssignableFrom(authentication);
    }

    private Account getAccount(SocialLoginResponse res){
        SocialUserProperty property = service.getSocialUserProperty(res);

        String userId = property.getUserId();
        SocialProviders provider = res.getProviders();

        return accountRepository.findBySocialIdAndSocialProviders(Long.valueOf(userId), provider)
                .orElseGet(() -> accountRepository.save(
                        new Account(null, property.getUserNickname(), "SOCIAL_USER", String.valueOf(UUID.randomUUID().getMostSignificantBits()), UserRole.USER, Long.valueOf(property.getUserId()), provider, property.getProfileHref())));

    }

}
