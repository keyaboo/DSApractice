package com.leetcode.badstrategies;

import java.util.*;

/**
 * create an arraylist as the value, insert string values positionally, +1 the index since the lowest timestamp is 1
 *
 * something interesting here: you can't just add
 *
 * how to create a
 */
public class TimeMap_981 {
    HashMap<String, List<String>> timeMap;
    public TimeMap_981() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (this.timeMap.containsKey(key)) {
            List<String> timedValues = this.timeMap.get(key);
            if (timestamp - 1 > timedValues.size()) {
                List<String> newTimedValues = new ArrayList<>(timestamp);
                newTimedValues.addAll(0, timedValues);
                newTimedValues.add(timestamp - 1, value);
                this.timeMap.put(key, newTimedValues);
            } else {
                timedValues.add(timestamp - 1, value);
            }
        } else {
            List<String> timedValues = new ArrayList<>();
            timedValues.add(timestamp - 1, value);
            this.timeMap.put(key, timedValues);
        }
    }

    public String get(String key, int timestamp) {
        List<String> timedValues = this.timeMap.get(key);
        if (timedValues.size() < timestamp - 1) {
            return null;
        } else {
            for (int i = timestamp - 1; i >= 0; i--) {
                if (!(timedValues.get(i) == null)) {
                    return timedValues.get(i);
                }
            }
        }
        return null;
    }


}
