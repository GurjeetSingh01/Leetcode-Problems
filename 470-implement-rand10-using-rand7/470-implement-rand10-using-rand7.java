class Solution extends SolBase {
    public int rand10() {
        int result = ((rand7() - 1)*7) + rand7();
        if(result > 40)
            return rand10();
        return (result%10) + 1;
    }
}