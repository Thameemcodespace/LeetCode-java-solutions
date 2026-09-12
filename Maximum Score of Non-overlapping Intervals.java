class State {
    long score; 
    List<Integer> ids; 
    State(int sc, List<Integer> ids) {
        this.score = sc; 
        this.ids = ids; 
    }
    State(State s) {
        this.score = s.score; 
        this.ids = new ArrayList<>(s.ids);
    }
    State() {
        this.score = 0;
        this.ids = new ArrayList<>();
    }
}
class Intervals {
    int st, en, idx, weight; 
    Intervals(int s, int e, int i, int w) {
        st = s; 
        en = e; 
        idx = i; 
        weight = w; 
    }
}
class Solution {   
    public int[] maximumWeight(List<List<Integer>> intervals) { 
        int n = intervals.size(); 
        List<Intervals> in = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            in.add(new Intervals(intervals.get(i).get(0), intervals.get(i).get(1), i, intervals.get(i).get(2))); 
        }
        Collections.sort(in, (a, b) -> {
            if(a.en != b.en) return Integer.compare(a.en, b.en); 
            return Integer.compare(a.st, b.st); 
        }); 
        State[][] dp = new State[n + 1][5]; 
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                dp[i][j] = new State();
            }
        }
        for(int i = 1; i <= n; i++) {
            int target = in.get(i -1).st, lo = 0, hi = i - 2; 
            int pos = 0; 
            while(lo <= hi) {
                int mid = (lo + hi) >> 1; 
                if(in.get(mid).en < target) {
                    pos = mid + 1; 
                    lo = mid + 1; 
                } else {
                    hi = mid - 1; 
                }
            }
            for(int j = 1; j <= 4; j++) {
                dp[i][j] = new State(dp[i-1][j]);  
                State prev = new State(dp[pos][j-1]); 
                prev.score += in.get(i -1).weight;
                prev.ids.add(in.get(i-1).idx); 
                Collections.sort(prev.ids);
                update(dp[i][j], prev); 
            }
        }
        State bestState = dp[n][1];
        for (int j = 2; j <= 4; j++) {
            if (dp[n][j].score > bestState.score) {
                bestState = dp[n][j];
            } else if (dp[n][j].score == bestState.score && !dp[n][j].ids.isEmpty()) {
                if (isSmaller(dp[n][j].ids, bestState.ids)) {
                    bestState = dp[n][j];
                }
            }
        }
        int ansLen = dp[n][4].ids.size(); 
        int ans[] = new int[ansLen]; 
        for(int i = 0; i < ansLen; i++) ans[i] = dp[n][4].ids.get(i); 
        return ans; 
    }
    private void update(State cur, State candidate) {
        if(cur.score < candidate.score) { 
            cur.score = candidate.score; 
            cur.ids = new ArrayList<>(candidate.ids); 
        } else if(cur.score == candidate.score && !candidate.ids.isEmpty()) {
            if(isSmaller(candidate.ids, cur.ids)) {
                cur.score = candidate.score; 
                cur.ids = new ArrayList<>(candidate.ids); 
            }
        }
    }
    private boolean isSmaller(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}
