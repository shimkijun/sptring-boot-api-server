package com.myproject.study.repository;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApiRepository extends JpaRepository<User,Long> {

    Header<UserApiResponse> findByEmailAndPassword(UserApiRequest request);
}
