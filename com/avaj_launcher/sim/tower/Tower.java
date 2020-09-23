package com.avaj_launcher.sim.tower;

import com.avaj_launcher.sim.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if(!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable) {
        if(observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }

    protected void conditionsChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
    }
}
