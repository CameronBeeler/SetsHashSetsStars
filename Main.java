package com.cambeeler;

import java.util.*;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {
	// write your code here
        populateData();
        Set<String> planets = solarSystem.keySet();
        for(String planet: planets){
            System.out.println(planet);
            if(solarSystem.get(planet).getSatelites().isEmpty()){
                System.out.println("Sorry, no moons...");
                System.out.println();
                continue;
            }
            Iterator<HeavenlyBody> moons = solarSystem.get(planet).getSatelites().iterator();

            while(moons.hasNext()){
                System.out.print("\t" + moons.next().toString() );
            }
            System.out.println();
        }
        System.out.println("+++++++++++++++++++++++");
        HeavenlyBody body = solarSystem.get("Jupiter");
        String temp="";

        for (HeavenlyBody m :body.getSatelites()){
//            System.out.println(m);
            temp += m;
//            System.out.println(body.getSatelites());
        }
        System.out.println(temp);

        for(String m:solarSystem.keySet()){
            moons.addAll(solarSystem.get(m).getSatelites());
        }
        String moonsMaster="";
        Iterator<HeavenlyBody> moon = moons.iterator();
        while(moon.hasNext()){
            moonsMaster += moon.next();
        }
        System.out.println("\n\rMoons of the Solar System Master Printout");

        System.out.println(moonsMaster);

    }

    public static void populateData(){
        solarSystem.put("Mercury",  new HeavenlyBody("Mercury",     88));

        solarSystem.put("Venus",    new HeavenlyBody("Venus",       224));

        solarSystem.put("Earth",    new HeavenlyBody("Earth",       365));
        solarSystem.get("Earth").AddMoon(new HeavenlyBody("Moon", 28));

        solarSystem.put("Mars",     new HeavenlyBody("Mars",        687));
        solarSystem.get("Mars").AddMoon(new HeavenlyBody("Phobos", .35));
        solarSystem.get("Mars").AddMoon(new HeavenlyBody("Deimos", 1.3));

        solarSystem.put("Jupiter",  new HeavenlyBody("Jupiter",     4332));
        solarSystem.get("Jupiter").AddMoon(new HeavenlyBody("Io", 1.77));
        solarSystem.get("Jupiter").AddMoon(new HeavenlyBody("Europa", 3.55));
        solarSystem.get("Jupiter").AddMoon(new HeavenlyBody("Ganymede", 7.16));
        solarSystem.get("Jupiter").AddMoon(new HeavenlyBody("Callisto", 16.69));

        solarSystem.put("Saturn",   new HeavenlyBody("Saturn",      10755));
        solarSystem.get("Saturn").AddMoon(new HeavenlyBody("Titan", 15.9));
        solarSystem.get("Saturn").AddMoon(new HeavenlyBody("Enceladus", 1.4));
        solarSystem.get("Saturn").AddMoon(new HeavenlyBody("Iapetus", 79.3));
        solarSystem.get("Saturn").AddMoon(new HeavenlyBody("Rhea", 4.5));

        solarSystem.put("Uranus",   new HeavenlyBody("Uranus",      30687));
        solarSystem.get("Uranus").AddMoon(new HeavenlyBody("Miranda", 1.4));
        solarSystem.get("Uranus").AddMoon(new HeavenlyBody("Titania", 8.7));

        solarSystem.put("Neptune",  new HeavenlyBody("Neptune",     60190));
        solarSystem.get("Neptune").AddMoon(new HeavenlyBody("Triton", 5.9));
        HeavenlyBody.addPlanet("Earth", 385);

        HeavenlyBody.displayPlanets();
    }
}
