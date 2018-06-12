package com.cambeeler;

import java.lang.reflect.Array;
import java.util.*;


public class SetMain {
    public static Set<Integer> squares = new HashSet<>();
    public static Set<Integer> cubes = new HashSet<>();


    public static void main(String[] args) {
       // create a set that is the set of all squares
       // create a second set that is

       for (int i =1; i<=100 ;i++){
           squares.add(i*i);
           cubes.add(i*i*i);
       }
        System.out.println("There are " + squares.size() + " square values and " + cubes.size() + " cube values");

       Set<Integer> union = new HashSet<>(squares);
       union.addAll(cubes);
        System.out.println("Union of squares and cubes contains " + union.size() + " elements");
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection of squares and cubes contains " + intersection.size() + " elements");
        for (int i:intersection){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube root of " + Math.cbrt(i));
        }

        List sortedSquares = new ArrayList(squares);
        List sortedCubes = new ArrayList(cubes);

        Collections.sort(sortedSquares);
        Collections.sort(sortedCubes);

        for (int i=0; i<100; i++){
            System.out.println(i+1 + " <-Index::Square-> " + sortedSquares.get(i) + " \tand Cubes-> " + sortedCubes.get(i));
        }

    }
}
