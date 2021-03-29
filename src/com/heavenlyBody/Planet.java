package com.heavenlyBody;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }
    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType().equals(BodyTypes.MOON))
            return super.addSatellite(moon) ;
        else {
            System.out.println("moon not added");
            return false;
        }
    }
}

