package com.myproject.study.repository;

import com.myproject.study.domain.Block;
import com.myproject.study.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
