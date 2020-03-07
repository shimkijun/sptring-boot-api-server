package com.myproject.study.controller;

import com.myproject.study.domain.Person;
import com.myproject.study.service.PersonApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/person")
public class PersonController {

    private final PersonApiLogicService personApiLogicService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personApiLogicService.getPerson(id);
    }

}
