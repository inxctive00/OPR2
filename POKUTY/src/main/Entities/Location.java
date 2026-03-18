package main.Entities;

import main.Signs.TrafficSign;
import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private List<TrafficSign> signs;

    public Location(String name) {
        setName(name);
        this.signs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrafficSign> getSigns() {
        return signs;
    }

    public void addSign(TrafficSign sign) {
        this.signs.add(sign);
    }
}