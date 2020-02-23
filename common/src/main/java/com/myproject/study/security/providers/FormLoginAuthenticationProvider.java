package com.myproject.study.security.providers;

import com.myproject.study.model.entity.Account;
import com.myproject.study.security.AccountContext;
import com.myproject.study.security.AccountRepository;
import com.myproject.study.security.tokens.PostAuthorizationToken;
import com.myproject.study.security.tokens.PreAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class FormLoginAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        PreAuthorizationToken token = (PreAuthorizationToken)authentication;

        String username = token.getUsername();
        String password = token.getUserPassword();

        Account account = accountRepository.findByUserId(username).orElseThrow(() -> new NoSuchElementException("정보에 맞는 계정이 없습니다."));

        if(isCorrectPassword(password, account)) {
            return PostAuthorizationToken.getTokenFromAccountContext(AccountContext.fromAccountModel(account));
        }

        throw new NoSuchElementException("인증 정보가 정확하지 않습니다.");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthorizationToken.class.isAssignableFrom(aClass);
    }

    private boolean isCorrectPassword(String password, Account account) {
        return passwordEncoder.matches(password,account.getPassword());
    }
}
