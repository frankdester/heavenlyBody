package com.heavenlyBody;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTERIOD
    }

    public HeavenlyBody(String name,double orbitalPeriod, BodyTypes bodyType){
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites =  new HashSet<>();
    }
    public Key getKey() {
        return this.key;
    }
    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }
    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }
    public boolean addSatellite (HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }
    public static Key makeKey(String name,BodyTypes bodyTypes){
        return new Key(name,bodyTypes);
    }
    @Override
    public final boolean equals(Object obj){
        if(this == obj)
            return true;

//        System.out.println("obj.getclass "+obj.getClass());
//        System.out.println("this.getclass "+this.getClass());
//        if((obj == null) || obj.getClass() != this.getClass()) //or !(obj instanceof HeavenlyBody)
//            return false;
//
//        String objName = ((HeavenlyBody) obj).getBodyType();
//        return this.bodyType.equals(objName);

        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObj = (HeavenlyBody) obj;//is it still needed?
            return this.key.equals(theObj.getKey());
        }
        return false;
    }
    @Override
    public final int hashCode() {
        return this.key.name.hashCode()+57+this.key.bodyType.hashCode();
    }
    @Override
    public String toString() {
        return this.key.toString()+" "+this.orbitalPeriod;
    }
    public static final class Key{
        private final String name;
        private final BodyTypes bodyType;

        private Key(String name,BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }
        public BodyTypes getBodyType(){
            return this.bodyType;
        }
        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            if(obj instanceof Key) {
                Key key = (Key) obj;
                if (this.name.equals((key.getName())))
                    return this.bodyType == key.getBodyType();
            }
            return false;
        }
        @Override
        public int hashCode() {
            return this.name.hashCode()+57+this.bodyType.hashCode();
        }
        @Override
        public String toString() {
            return this.name+": "+this.bodyType;
        }

    }
}

