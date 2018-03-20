package org.interview.questions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CartesianProduct {
    /*
     * ##Company-Google 
     * ##Hard 
     * Find cartesian product of two sets: 
     * Example: (a, b) X (c, d) = ((a, c), (a, d), (b, c), (b, d))
     * 
     * Reason for Fuck up -
     * Was so busy with wholistic view AND dimensions that I didn't divide the problem into smaller ones.
     * A X B X C = (A X B) X C 
     */
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList() {{
            add(new ArrayList() {{
                add(1);
                add(2);
                add(3);
            }});
            add(new ArrayList() {{
                add(4);
                add(5);
                add(6);
            }});
            add(new ArrayList() {{
                add(7);
                add(8);
                add(9);
            }});
        }};
        System.out.println("----------------------------------");
        System.out.println(input);
        System.out.println(cartesianProduct(input));
        System.out.println("----------------------------------");

        input = new ArrayList() {{
            add(new ArrayList() {{
                add(1);
                add(2);
            }});
            add(new ArrayList() {{
                add(7);
                add(8);
            }});
        }}; 
        System.out.println("----------------------------------");
        System.out.println(input);
        System.out.println(cartesianProduct(input));
        System.out.println("----------------------------------");
        
        input = new ArrayList() {{
            add(new ArrayList() {{
                add(1);
                add(2);
                add(3);
            }});
            add(new ArrayList() {{
                add(7);
            }});
            
            add(new ArrayList() {{
                add(10);
                add(11);
                add(12);
            }});
        }}; 
        System.out.println("----------------------------------");
        System.out.println(input);
        System.out.println(cartesianProduct(input));
        System.out.println("----------------------------------");
        
    }

    private static List<List<Integer>> cartesianProduct(List<List<Integer>> input) {
        if (input == null) {
            return input;
        }
        return input.stream().reduce(new ArrayList<List<Integer>>(), (lol1, lst1) -> {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            lst1.forEach(element -> {
                List<List<Integer>> resSoFar = deepCopy(lol1);
                if (resSoFar.isEmpty()) {
                    resSoFar.add(new ArrayList<Integer>() {{ add(element); }}); 
                } else {
                    resSoFar.forEach(lol2 -> {
                        lol2.add(element);
                    });
                }
                res.addAll(resSoFar);
            });
            return res;
        }, (List<List<Integer>> lol1, List<List<Integer>> lol2) -> {
            lol1.addAll(lol2);
            return lol1;
        });
    }

    private static List<List<Integer>> deepCopy(List<List<Integer>> lol1) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        lol1.forEach(lst -> {
            List<Integer> newLst = new ArrayList<Integer>();
            lst.forEach(element -> {
                newLst.add(new Integer(element.intValue()));
            });
            res.add(newLst);
        });
        return res;
    }

}
