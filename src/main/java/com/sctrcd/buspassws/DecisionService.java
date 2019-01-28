package com.sctrcd.buspassws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sctrcd.buspassws.facts.Decision;
import com.sctrcd.buspassws.facts.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecisionService {

    private static Logger log = LoggerFactory.getLogger(DecisionService.class);

    private final KieContainer kieContainer;

    @Autowired
    public DecisionService(KieContainer kieContainer) {
        log.info("Initialising a new bus pass session.");
        this.kieContainer = kieContainer;
    }

    /**
     * Create a new session, insert a message's details and fire rules to
     * determine what kind of bus pass is to be issued.
     */
    public Decision getBusPass(Message message) {
        KieSession kieSession = kieContainer.newKieSession("aBPMSession");
        kieSession.insert(message);
        kieSession.fireAllRules();
        Decision decision = findBusPass(kieSession);
        kieSession.dispose();
        return decision;
    }
    
    /**
     * Search the {@link KieSession} for bus passes.
     */
    private Decision findBusPass(KieSession kieSession) {
        
        // Find all Decision facts and 1st generation child classes of Decision.
        ObjectFilter busPassFilter = new ObjectFilter() {

            public boolean accept(Object object) {
                if (Decision.class.equals(object.getClass())) return true;
                return Decision.class.equals(object.getClass().getSuperclass());
            }
        };

        // printFactsMessage(kieSession);
        
        List<Decision> facts = new ArrayList<Decision>();
        for (FactHandle handle : kieSession.getFactHandles(busPassFilter)) {
            facts.add((Decision) kieSession.getObject(handle));
        }
        if (facts.size() == 0) {
            return null;
        }
        // Assumes that the rules will always be generating a single bus pass. 
        return facts.get(0);
    }
    
    /**
     * Print out details of all facts in working memory.
     * Handy for debugging.
     */
    @SuppressWarnings("unused")
    private void printFactsMessage(KieSession kieSession) {
        Collection<FactHandle> allHandles = kieSession.getFactHandles();
        
        StringBuilder msg = new StringBuilder("\nAll facts:\n");
        for (FactHandle handle : allHandles) {
            msg.append("    ").append(kieSession.getObject(handle)).append("\n");
        }
        System.out.println(msg);
    }

}
