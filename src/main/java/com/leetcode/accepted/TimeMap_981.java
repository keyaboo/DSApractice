package com.leetcode.accepted;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * list and corresponding indices were definitely not the way to store things.
 * treemaps store key-value mappings based on the sorting order of the keys
 *
 * the treemap method "floorkey" avoids the having to write the null checking for loop to find the lowest value with
 * a valid string which is nice. it's a capital I Integer btw, so doing nullchecks is important.
 *
 * the treemap is not a particularly fast way of doing this, the hashmaps I'm seeing in other solutions are using
 * faster data structures like:
 * private Map<String, ArrayList<Node>> storage;
 * private final Map<K, ArrayList<TimeMapNode<V>>> timeMap = new HashMap<>();
 *
 * so yeah sometimes a private pojo class that houses the info like I was originally going to try can be faster,
 * but not nearly as easy to read I think.
 */
public class TimeMap_981 {
    HashMap<String, TreeMap<Integer, String>> timeMap;

    public TimeMap_981() {
        this.timeMap = new HashMap<>();
    }

    // the set part becomes super simple this way
    public void set(String key, String value, int timestamp) {
        if (this.timeMap.containsKey(key)) {
            TreeMap<Integer, String> treeMap = this.timeMap.get(key);
            treeMap.put(timestamp, value);
        } else {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            this.timeMap.put(key, treeMap);
        }
    }

    public String get(String key, int timestamp) {
        if (this.timeMap.containsKey(key)) {
            Integer floorKey = this.timeMap.get(key).floorKey(timestamp);
            if (floorKey != null) {
                return this.timeMap.get(key).get(floorKey);
            } else {
                return "";
            }
        }
        return "";
    }

}
