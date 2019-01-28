package com.sctrcd.buspassws.facts;

public class Decision {

    private Message message;

    public Decision(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getBusPassType() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public String toString() {
        return "Decision: { message=" + message + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Decision that = (Decision) o;
        return this.message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }
}
