class Solution {

    public boolean splitArraySameAverage(int[] arr) {
        
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        
        HashSet<Integer>[]check=new HashSet[n/2+1];
        for(int i=0;i<=n/2;i++){
            check[i]=new HashSet<>();
        }
        
        for(int i=0;i<((1<<n/2));i++){
            int sum1=0;
            int count=0;
            for(int  j=0;j<n/2;j++){
                if((i &(1<<j))>0){
                    count++;
                    sum1+=arr[n/2-1-j];
                }
                
            }
           check[count].add(sum1);
        }
       
        
                for(int i=0;i<((1<<n/2));i++){
            int sum1=0;
            int count=0;
            for(int  j=0;j<n/2;j++){
                if((i &(1<<j))>0){
                    count++;
                    sum1+=arr[n-1-j];
                }
                
            }
         for(int j=0;j<=n/2;j++){
             if(count+j==0 || count+j==n){
                 continue;
             }
             int tcount=j+count;
             if(((tcount*sum-n*sum1)%n)!=0){
                 continue;
             }
          if(check[j].contains((tcount*sum-n*sum1)/n)){
           
              return true;
          }
         }
        }
        return false;
       
        
    }
    
 
    
}