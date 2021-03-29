package com.heavenlyBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HeavenlyBodyMain {

    public static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    public static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);



        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        HeavenlyBody tempo = new Planet("Callia", 16.7);
        solarSystem.put(tempo.getKey(),tempo);
        temp.addSatellite(tempo);

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);


        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        System.out.println("jupiter planet with sets");
        for(HeavenlyBody planet : planets){
            if(planet.getKey().equals(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET))){
                for(HeavenlyBody jupiter : planet.getSatellites())
                    System.out.println("\t"+jupiter.getKey());

            }
        }

        System.out.println("jupiter planet with maps");
        for(HeavenlyBody solar : solarSystem.get(HeavenlyBody.makeKey("Jupiter", HeavenlyBody.BodyTypes.PLANET)).getSatellites())
            System.out.println("\t"+solar.getKey());

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }
        System.out.println("all moons");
        for(HeavenlyBody moon : moons)
            System.out.println("\t"+moon.getKey() );
        System.out.println("all planets");
        HeavenlyBody pluto = new DwarfPlanet( "Pluto", 848);
        planets.add(pluto);
        for(HeavenlyBody planet : planets){
            System.out.println("\t"+planet);
        }

        System.out.println("all planet from maps");
        for(HeavenlyBody solar : solarSystem.values())
            System.out.println("\t"+solar);

        System.out.println("Mars".equals("Mar"));
    }
}
