package com.leetcode.Dailies.October24;

import java.util.*;

/*
    Not terribly comfortable with string functions other than the charAt stuff.
 */
public class RemoveSubfolders_1233 {
    public List<String> removeSubfolders(String[] folder){
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String last = res.get(res.size() - 1);
            if (folder[i].startsWith(last) && folder[i].charAt(last.length()) == '/') {
                continue;
            } else {
                res.add(folder[i]);
            }
        }
        return res;
    }
}
