package com.myproject.study.security.repository;

import com.myproject.study.model.entity.Account;
import com.myproject.study.model.enumclass.SocialProviders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByUserId(String userId);

    Optional<Account> findBySocialId(String socialId);

    Optional<Account> findBySocialIdAndSocialProviders(Long socialId, SocialProviders socialProvider);

}
