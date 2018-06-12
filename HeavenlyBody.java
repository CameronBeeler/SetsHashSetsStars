package com.cambeeler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private static Set<String> planets = new HashSet<>();
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satelites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satelites = new HashSet<HeavenlyBody>();
        planets.add(name);
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean AddMoon(HeavenlyBody moon){
        if(this.satelites.contains(moon)){
            System.out.println("duplicate moon attempted");
           return false;
        }
        return (this.satelites.add(moon));
    }

    public Set<HeavenlyBody> getSatelites() {
        return new HashSet<>(this.satelites);

    }

    @Override
    public String toString() {
        return "Body: " + name + ", Orbital Period: " + orbitalPeriod + "\n\r";
    }

    @Override
    final public boolean equals(Object obj ){

        if(this == obj){ return true;} //same literal object
        if ((obj == null) || this.getClass() != obj.getClass()){return false;} // null or not the same class type

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equalsIgnoreCase(objName);

    }

    @Override
    public int hashCode() {
        //return Objects.hash(name, orbitalPeriod, satelites);
        return Objects.hash(name.toLowerCase(), satelites);
    }

    public static boolean isEqual(String planet){
        if(planets.contains(planet)){
            return true;
        }
        return false;
    }

    public static HeavenlyBody addPlanet(String planet, double orbital){
        if(isEqual(planet)){
            System.out.println("Cannot add duplicate planet ==> " + planet);
            return null;
        }
        planets.add(planet);
        return new HeavenlyBody(planet, orbital);
    }

    public static void displayPlanets(){
//        for(String p : planets){
//            System.out.println("Planet -> " + p);
//        }
      //  satelites.forEach(satelite -> System.out.println("planet Name -> " + satelite));
    }


}
