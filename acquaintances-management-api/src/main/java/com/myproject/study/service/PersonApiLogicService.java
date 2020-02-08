package com.myproject.study.service;

import com.myproject.study.domain.Block;
import com.myproject.study.domain.Person;
import com.myproject.study.repository.BlockRepository;
import com.myproject.study.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonApiLogicService {

    private final PersonRepository personRepository;

    private final BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
        List<Person> people = personRepository.findAll();

        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
    }

}
