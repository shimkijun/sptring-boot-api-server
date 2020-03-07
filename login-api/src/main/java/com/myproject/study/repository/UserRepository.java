package com.myproject.study.repository;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.response.UserApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
