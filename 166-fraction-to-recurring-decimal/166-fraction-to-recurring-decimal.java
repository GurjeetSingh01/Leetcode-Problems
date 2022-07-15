class Solution {
    private static final String MINUS = "-";
    private static final String DECIMAL_POINT = ".";
    private static final String OPENING_BRACKET = "(";
    private static final String CLOSING_BRACKET = ")";
    
    public String fractionToDecimal(int numerator, int denominator) {
        if(0==numerator){
            return "0";
        }
        
        StringBuilder formattedFraction = new StringBuilder();
        
        if(numerator<0 ^ denominator<0){
            formattedFraction.append(MINUS);
        }
        
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        
        formattedFraction.append(String.valueOf(dividend/divisor));
        long remainder = dividend%divisor;
        
        if(0==remainder){
            return formattedFraction.toString();
        }
        
        formattedFraction.append(DECIMAL_POINT);
        
        //Structure to Hash and Store all the Remainder Sequences we have encountered so far
        Map<Long,Integer> seqeuences = new HashMap<Long,Integer>();
        
        while(0!=remainder){
            if(seqeuences.containsKey(remainder)){
                formattedFraction.insert(seqeuences.get(remainder),OPENING_BRACKET);
                formattedFraction.append(CLOSING_BRACKET);
                break;
            }
            
            seqeuences.put(remainder,formattedFraction.length());
            remainder*=10;
            formattedFraction.append(String.valueOf(remainder/divisor));
            remainder %= divisor; 
        }
        
        return formattedFraction.toString();
    }
    
}