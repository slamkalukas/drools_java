package com.sctrcd.buspassws.facts;

public class OkDecision extends Decision {

    public OkDecision(Message message) {
        super(message);
    }
    
    @Override
    public String toString() {
        return "OkDecision: { person=" + getMessage() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        OkDecision that = (OkDecision) o;
        return getMessage().equals(that.getMessage());
    }

    @Override
    public int hashCode() {
        return getMessage().hashCode();
    }

}
