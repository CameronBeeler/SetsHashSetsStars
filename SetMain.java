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
        Set<String> words = new HashSet<>();
        String sentence = "One day in the year of the fox";
        String[] arraywords = sentence.split(" ");
        words.addAll(Arrays.asList(arraywords));

        for (String s:words){
            System.out.println(s);
        }
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "but", "to", "forgive", "is", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);

//  Asymmetric difference - the elements of one set - the elements of another (no union members)
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        System.out.print("\nnature - divine:\t");
        printSet(diff1);
        System.out.print("\ndivine - nature:\t");
        printSet(diff2);

//  Symmetric difference is the union of two sets - remove the common elements
//  Union is the whole join of all members of both sets
//  Intersection are the elements in common from both sets
//  Sets / HashSets do NOT allow duplication
//  To obtain the Symmetric difference, we must acquire the Union and remove the Intersection

        Set<String> Union = new HashSet<>(divine);
        Union.addAll(nature);

        Set<String> iSection = new HashSet<>(divine);
        iSection.retainAll(nature);

        Set<String> symDiff = new HashSet<>(Union) ;
        symDiff.removeAll(iSection);
        System.out.print("\nSymmetric Difference:\t");

        printSet(symDiff);

//  Inverse Symmetric difference
        System.out.print("\nIntersection:\t");

        printSet(iSection);

//  containsAll is a non-destructive bulk method evaluation...
        if(divine.containsAll(iSection)){
            System.out.println("iSection is a subset of divine");
        }
        if (nature.containsAll(iSection)){
            System.out.println("iSection is a subset of nature");
        }

    }


    private static void printSet(Set<String> str){
        for (String s:str){
            System.out.print(s + " ");

        }
        System.out.println();
    }
}
