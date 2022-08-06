/**************************************************************************************************************************************************************
Using map to keep track of the elements in the secret string and checking all the cow possibilities in the given guess
****************************************************************************************************************************************************************/

class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        
        // track the characters in the secret that are not bulls to check the possibility of bulls
        //      the digits that are both in guess and secret but at different positions
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        for(char ch: secret.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 0);
            }
            // equals mean bulls
            // dont put in map bcoz we should not rearrage the bulls as they are already in the correct place
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else {
                // track the count too, we can only rearrage as many as there are in secret
                map.put(ch, map.get(ch)+1);   
            }
            i++;
        }
        
        i = 0;
        for(i=0;i<secret.length();i++){
            // if not bull and there exists a matching char in secret
            if(secret.charAt(i) != guess.charAt(i) && map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0){
                map.put(guess.charAt(i), map.get(guess.charAt(i))-1);
                cows++;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}

/**************************************************************************************************************************************************************
Using COUNTING

****************************************************************************************************************************************************************/

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] scnt = new int[10];
        int[] gcnt = new int[10];
        
        int bulls = 0;
        int cows = 0;
        
        for(int i=0;i<n;i++){
            // equals mean bulls
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else {
            // keep track of the count, which we can calculate the cows
                scnt[secret.charAt(i)-'0']++;
                gcnt[guess.charAt(i)-'0']++;
            }
        }
        
        for(int i=0;i<10;i++){
            // atleast one digit should be there for the cow to be present
            if(gcnt[i]!=0){
                /*
                    1. scnt[i]>gcnt[i]
                            The same digit is there more times in secret than in guess.
                            We can only move the digits which are in guess, we cannot genereate new
                        We are taking the minimum
                    2. scnt[i] == gcnt[i]
                            We can move all the digits in guess into correct positions in secret
                    3. scnt[i]<gcnt[i]
                            Even if we have more digits in guess, there is nothing to match in secret
                            So we can match what is there in secret
                        We are taking minimum here too
                            
                */
                cows += Math.min(gcnt[i], scnt[i]);
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
