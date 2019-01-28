package com.sctrcd.buspassws.facts;

public class BadDecision extends Decision {

    public BadDecision(Message message) {
        super(message);
    }

    @Override
    public String toString() {
        return "BadDecision: { person=" + getMessage() + " }";
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