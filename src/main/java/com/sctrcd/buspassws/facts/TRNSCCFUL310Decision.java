package com.sctrcd.buspassws.facts;

public class TRNSCCFUL310Decision extends Decision {

    public TRNSCCFUL310Decision(Message message) {
        super(message);
    }

    @Override
    public String toString() {
        return "TRNSCCFUL300 Decision: { result=" + getMessage() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BadDecision that = (BadDecision) o;
        return getMessage().equals(that.getMessage());
    }

    @Override
    public int hashCode() {
        return getMessage().hashCode();
    }
    
}