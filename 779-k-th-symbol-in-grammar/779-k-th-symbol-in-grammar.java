class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1 && k==1)
          return 0;        
        int prevLayerSize = (int) Math.pow(2, n-2);
        if(k<= prevLayerSize){
            return kthGrammar(n-1, k);
        } else {
            return kthGrammar(n-1, k-prevLayerSize) ^ 1;
        }
    }
}

