package com.myproject.study.service;

import com.myproject.study.domain.Block;
import com.myproject.study.domain.Person;
import com.myproject.study.repository.BlockRepository;
import com.myproject.study.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonApiLogicServiceTests {

    @Autowired
    private PersonApiLogicService personApiLogicService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    @Transient
    void getPeopleExcludeBlocks(){
        givenPeople();

        List<Person> result = personApiLogicService.getPeopleExcludeBlocks();

        result.forEach(System.out::println);
    }

    void givenPeople(){
        givenPerson("martin",10,"A");
        givenPerson("david",9,"B");
        givenBlockPerson("dennis",7,"O");
        givenBlockPerson("martin",1,"AB");
    }

    void givenBlockPerson(String name,int age,String bloodType){
        Person blockPerson = Person.builder().name(name).age(age).bloodType(bloodType).build();
        blockPerson.setBlock(Block.builder().name(name).build());
        personRepository.save(blockPerson);
    }


    void givenPerson(String name, int age, String bloodType) {
        personRepository.save(Person.builder()
                .name(name).age(age).bloodType(bloodType).build());
    }

    @Test
    void cascadeTest(){
        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);

        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson(){

        Person person = personApiLogicService.getPerson(3L);

        System.out.println(person);
    }
}