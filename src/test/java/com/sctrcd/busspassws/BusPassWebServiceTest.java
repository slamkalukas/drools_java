package com.sctrcd.busspassws;

import static org.junit.Assert.*;

import com.sctrcd.buspassws.facts.Message;
import com.sctrcd.buspassws.facts.OkDecision;
import com.sctrcd.buspassws.facts.BadDecision;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sctrcd.buspassws.DecisionApp;
import com.sctrcd.buspassws.DecisionService;
import com.sctrcd.buspassws.facts.Decision;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DecisionApp.class)
@WebAppConfiguration
public class BusPassWebServiceTest {

    @Autowired
    private DecisionService busPassService;

    @Test
    public void shouldIssueAdultBusPass() {
        Message message = new Message("Steve", 16);
        Decision decision = busPassService.getBusPass(message);
        
        System.out.println("Bus pass: " + decision);
        
        assertEquals(OkDecision.class, decision.getClass());
    }
    
    @Test
    public void shouldIssueChildBusPass() {
        Message message = new Message("Steve", 15);
        Decision decision = busPassService.getBusPass(message);
        
        System.out.println("Bus pass: " + decision);
        
        assertEquals(BadDecision.class, decision.getClass());
    }

}
