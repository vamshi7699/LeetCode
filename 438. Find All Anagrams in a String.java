/**************************************************************************************************************************************************************
MAP AND COUNT
    Can also try with the counting array instead of the maps
    
Anagrams are strings that have same characters in same frequency
    order does not matter
****************************************************************************************************************************************************************/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // track the string characters that needs to be matched for anagram
        Map<Character, Integer> anagramMap = new HashMap<>();
        int anagramLen = p.length();
        for(char ch: p.toCharArray()){
            anagramMap.put(ch, anagramMap.getOrDefault(ch, 0) + 1);
        }
        
        // lets say we need to find the anagram chars in the given substring
        // we need to know the chars in anagram ,so use this map
        Map<Character, Integer> possibleSubStrMap = new HashMap<>(anagramMap);
        // if we find a matching character, increase the count
        //      Once we reach a substring of length of the anagram and this count is equal to the length of the anagram, then this can be included in result
        int anagramMatchingSubStrCharactersCnt = 0;
        
        
        // take 2 indices to tarck the starting and ending positions of the substrings
        int startIndex = 0;
        int endIndex = 0;
        
        List<Integer> res = new ArrayList<>();
        
        while(endIndex<s.length()){
            // if the difference between the indices is less than the anagram length it is impossible from the substring to form an anagram
            // so we check for the matches of the characters
            if(endIndex-startIndex<anagramLen){
                // get the count of the char in the anagram
                Integer charCnt = possibleSubStrMap.get(s.charAt(endIndex));
                
                // the char is not present in the anagram, so discard the entire current substring
                if(charCnt == null){
                    endIndex++;
                    startIndex=endIndex;
                    
                    possibleSubStrMap = new HashMap<>(anagramMap);
                    anagramMatchingSubStrCharactersCnt = 0;
                    
                // the cnt becomes 0 when the char is already present in the substring
                // the current substring cannot be anagram
                //      But the  next substring which includes the current char(the one that gave cnt 0) can be anagram
                //  So remove the startIndex
                } else if(charCnt <= 0) {
                    anagramMatchingSubStrCharactersCnt--;
                    possibleSubStrMap.put(s.charAt(startIndex), possibleSubStrMap.get(s.charAt(startIndex)) + 1);
                    startIndex++;
                
                // char match, so update the cnts
                } else {
                    possibleSubStrMap.put(s.charAt(endIndex), charCnt-1);
                    anagramMatchingSubStrCharactersCnt++;
                    endIndex++;
                }
                
            // here the substring length is same as that of anagram
            //      and so if the matched character is same as length then all are found and is a part of result
            } else if(anagramMatchingSubStrCharactersCnt == anagramLen){
                res.add(startIndex);
                
                // we cannot move the starting index to the end, because the substring of the substring can still be a part of the anagram
                // Eg: abca , aba
                //      Once we find 'abc', we cannot move to next a
                //      Coz even 'bca' can be an anagram
                // so only move by one index and include the element that is removed from the substring i.e, the startIndex char
                //      also the substring anagram lenght decreases as we are removign a matching char
                anagramMatchingSubStrCharactersCnt--;
                possibleSubStrMap.put(s.charAt(startIndex), 1);
                startIndex++;
            
            // here the substring length is same as that of anagram
            //      but the number of matching chars is not same as length, so all chars are not present 
            } else {
                
                startIndex=endIndex;
                possibleSubStrMap = new HashMap<>(anagramMap);
                anagramMatchingSubStrCharactersCnt = 0;
            }
        }
        
        // Once endIndex reached the last, check for anagram possibility
        //      Since in above while loop, we check if the substring is anagram only after moving to the next index of the substring
        //   i.e, if substr = 'abc'de, anagram='abc'
        //      we check if 'abc' is anagram only after moving to 'd'
        // and the above loop runs only to last index and it cannot check if there is anagram with the last index included
        //      Eg: abab, ab
        if(anagramMatchingSubStrCharactersCnt == anagramLen){
            res.add(startIndex);
        }
        
        return res;
    }
}
