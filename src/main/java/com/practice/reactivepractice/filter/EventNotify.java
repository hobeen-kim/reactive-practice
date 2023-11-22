package com.practice.reactivepractice.filter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class EventNotify {

    private List<String> events = new ArrayList<>();

    private boolean change = false;

    public void add(String data) {
        events.add(data);
        change = true;
    }

    public List<String> getEvents() {
        change = false;
        return events;
    }

    public boolean getChange() {
        return change;
    }
}
