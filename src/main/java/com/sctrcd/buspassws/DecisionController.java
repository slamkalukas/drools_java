package com.sctrcd.buspassws;

import com.sctrcd.buspassws.facts.Decision;
import com.sctrcd.buspassws.facts.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DecisionController {

    private static Logger log = LoggerFactory.getLogger(DecisionController.class);

    private final DecisionService decisionService;

    @Autowired
    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @RequestMapping(value = "/makeDecision", method = RequestMethod.GET, produces = "application/json")
    public Decision getQuestions(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) int age) {

        Message message = new Message(name, age);

        log.debug("New request received for: " + message);
        
        Decision decision = decisionService.getBusPass(message);

        return decision;
    }

    @RequestMapping(value = "/makeDecision2", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Decision> getQuestions2() {

        Message message = new Message("Lukas", 11);

        log.debug("New request received for: " + message);

        Decision decision = decisionService.getBusPass(message);

        return new ResponseEntity<Decision>(decision, HttpStatus.OK);
    }

    @RequestMapping(value = "/makeDecision3", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Decision> getQuestions3(@RequestBody Message message) {

        log.debug("New request received for: " + message);

        Decision decision = decisionService.getBusPass(message);

        return new ResponseEntity<Decision>(decision, HttpStatus.OK);
    }
}
