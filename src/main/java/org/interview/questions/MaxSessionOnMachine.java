package org.interview.questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/*
 * Given : Session start time and duration
 * Output: Max number of sessions at any given point in time.
 */

public class MaxSessionOnMachine {

    public static final String PATTERN = "dd/MM/yyyy HH:mm:ss";

    /*
     * ##Company-EMC ##Greedy algorithm ##Hard Given the start time of session and the duration of each session, when
     * was the num of session on the machine maximum. Algorithm:- a. Start Time and End Time are points of change b. At
     * start time number of Session += 1 and end time -= 1. Find the max time from the final Time list.
     */
    public static void main(String[] args) {
        TreeMap<LocalDateTime, Integer> map;
        try {
            map = getInputValues("./src/main/resources/MaxSessionOnMachine.txt");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        Integer maxValue = Integer.MIN_VALUE;
        Integer counter = 0;
        System.out.println("[DEBUG] Map: " + map);
        for (Map.Entry<LocalDateTime, Integer> entry : map.entrySet()) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("[DEBUG] Entry: " + entry);
            counter += entry.getValue();
            if (counter.compareTo(maxValue) > 0) {
                maxValue = counter;
            }
            System.out.println("[DEBUG] Current counter = " + counter);
            System.out.println("[DEBUG] Current maxValue = " + maxValue);

        }
        System.out.println("\n\n\nMax Sessions on system = " + maxValue);
    }

    private static TreeMap<LocalDateTime, Integer> getInputValues(String file)
            throws NumberFormatException, IOException {
        TreeMap<LocalDateTime, Integer> map = new TreeMap<LocalDateTime, Integer>();
        FileInputStream fstream = new FileInputStream(file);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] parts = strLine.split("\\|", -1);
                LocalDateTime startTime = LocalDateTime.parse(parts[0], formatter);
                Integer durationInMillis = Integer.parseInt(parts[1]) * 1000;
                LocalDateTime endTime = startTime.plusSeconds(TimeUnit.MILLISECONDS.toSeconds(durationInMillis));
                if (map.containsKey(startTime)) {
                    map.put(startTime, map.get(startTime) + 1);
                } else {
                    map.put(startTime, 1);
                }

                if (map.containsKey(endTime)) {
                    map.put(endTime, map.get(endTime) - 1);
                } else {
                    map.put(endTime, -1);
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
}
