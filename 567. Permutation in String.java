class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];
        // we need the list of all chars and counts present in the actual string
        for(char x:s1.toCharArray()){
            a[x-97]++;
        }
        
        int s2len=s2.length(),s1len=s1.length();
        int i, j;
        // to check if all the chars are found in the search string
        int p=s1len;

        for(i=0,j=0;j<s2len;){
            
            // this is a char that is not in the actual str
            if(a[s2.charAt(j)-97]==0){
                // this means that all the chars are found
                if(p==0)
                    return true;
                
                // we have a sliding window
                // move the left end and update the variables
                if(i!=j){
                    p++;
                    a[s2.charAt(i)-97]++;
                    i++;
                } else{
                // if both are equals there is not point in moving left window to the right of right end i.e, invalid
                    i++;
                    j++;
                }
            } else{
                // char is there in search string
                p--;
                a[s2.charAt(j)-97]--;
                j++;
            }
        }
        // check if all the chars are presnt
        return p==0;
    }
}
