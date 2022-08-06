class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int f1 = (minutesToTest/minutesToDie) + 1;
        int tt = 0;
        int all = 1;
        while (all < buckets) {
            all *= f1;
            tt++;
        }
        return tt;
    }
}