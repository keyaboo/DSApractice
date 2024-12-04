package com.codeforces.contests.Div2Round172.Recommendations;

import java.util.*;

/*
Looking at editorial: yes next largest interval is what we're trying to find. Sorting criteria is the
tracks[0] term not the width. If l_j, r_j is the interval we want to find predictions for, then we're
going to do a binary search in [L, l_j) to find an l_i for which r_i > r_j. Sort segments by l_i, using
r_i as a tiebreaker. The solution recommends a freqs map rather than one that holds indices of the
original tracks. A question, since I am not terribly familiar with TreeSets, is what happens if we haven't
seen the ideal interval yet to call ceiling? That's already solved by having the intervals in ascending
left interval values added to the treeset already. The flip is clever to repeat the same process going
in the other direction.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {

                int t = sc.nextInt();
                for (int i = 0; i < t; i++) {
                    int n = sc.nextInt();
                    Long[][] tracks = new Long[n][2];
                    for (int j = 0; j < n; j++) {
                        tracks[j][0] = sc.nextLong();
                        tracks[j][1] = sc.nextLong();
                    }
                    List<Long> res = getStrongRecommendations(tracks);
                    for (int k = 0; k < res.size(); k++) {
                        System.out.println(res.get(k));
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }

    }


    public static List<Long> getStrongRecommendations(Long[][] tracks) {
        List<Seg> segments = new ArrayList<>();
        for (int i = 0; i < tracks.length; i++) {
            Seg seg = new Seg(tracks[i][0], tracks[i][1]);
            segments.add(seg);
        }
        List<Long> res = new ArrayList<>(Collections.nCopies(tracks.length, 0L));
        for (int k = 0; k < 2; k++) {
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < tracks.length; i++) {
                indices.add(i);
            }

            Collections.sort(indices, (i, j) ->
                segments.get(i).compareTo(segments.get(j))
            );
            TreeSet<Long> bounds = new TreeSet<>();
            for (int i : indices) {
                // System.out.println(segments.get(i));
                Long smallestRight = bounds.ceiling(segments.get(i).end);
                if (smallestRight != null) {
                    res.set(i, res.get(i) + smallestRight - segments.get(i).end);
                }
                bounds.add(segments.get(i).end);
            }
            for (int i = 0; i < segments.size(); i++) { // this is flipping everything and doing right to left sweep.
                segments.get(i).flipSeg();
            }

        }
        HashMap<String, Integer> counts = new HashMap<>();
        for (Seg s : segments) {
            String key = s.start + "_" + s.end;
            counts.put(key, counts.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < segments.size(); i++) {
            String key = segments.get(i).start + "_" + segments.get(i).end;
            if (counts.get(key) > 1) {
                res.set(i, 0L);
            }
        }
        return res;
    }

    private static class Seg implements Comparable<Seg> {
        public long start;
        public long end;

        Seg(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public void flipSeg() {
            this.start = (-1) * this.start;
            this.end = (-1) * this.end;
            long temp = this.start;
            this.start = this.end;
            this.end = temp;
        }
        @Override
        public int compareTo(Seg other) {
            if (start != other.start) {
                return Long.compare(this.start, other.start); // returns smaller of this.start & other.start
            }
            return Long.compare(other.end, this.end); // returns larger of this.end and other.end
            // prioritize longest
        }
        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }

        /*
        nice to know how to do this but just making it a string is fine too.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seg seg = (Seg) o;
            return start == seg.start && end == seg.end;
        }
        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }


    }
}
