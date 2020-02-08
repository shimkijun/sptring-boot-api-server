package com.myproject.study.service;

import com.myproject.study.domain.Block;
import com.myproject.study.domain.Person;
import com.myproject.study.repository.BlockRepository;
import com.myproject.study.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class BlockApiLogicServiceTests {

    @Autowired
    private PersonApiLogicService personApiLogicService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();
        givenBlocks();

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
        blockPerson.setBlock(givenBlock(name));

        personRepository.save(blockPerson);
    }

    void givenBlocks(){
        givenBlock("martin");
    }

    Block givenBlock(String name) {
        return blockRepository.save(Block.builder().name(name).build());
    }

    void givenPerson(String name, int age, String bloodType) {
         personRepository.save(Person.builder()
                    .name(name).age(age).bloodType(bloodType).build());
    }
}