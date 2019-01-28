package com.sctrcd.buspassws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sctrcd.buspassws.facts.BusPass;
import com.sctrcd.buspassws.facts.Person;

@RestController
public class DecisionController {

    private static Logger log = LoggerFactory.getLogger(DecisionController.class);

    private final DecisionService decisionService;

    @Autowired
    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @RequestMapping(value = "/buspass", 
            method = RequestMethod.GET, produces = "application/json")
    public BusPass getQuestions(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) int age) {

        Person person = new Person(name, age);

        log.debug("Bus pass request received for: " + person);
        
        BusPass busPass = decisionService.getBusPass(person);

        return busPass;
    }

    @RequestMapping(value = "/buspass2", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<BusPass> getQuestions2() {

        Person person = new Person("Lukas", 11);

        log.debug("Bus pass request received for: " + person);

        BusPass busPass = decisionService.getBusPass(person);

        return new ResponseEntity<BusPass>(busPass, HttpStatus.OK);
    }

    @RequestMapping(value = "/buspass3", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<BusPass> getQuestions3(@RequestBody Person person) {

        log.debug("Bus pass request received for: " + person);

        BusPass busPass = decisionService.getBusPass(person);

        return new ResponseEntity<BusPass>(busPass, HttpStatus.OK);
    }

}
