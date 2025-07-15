/* 

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

*/

class Solution {
    public String frequencySort(String s) {

        Map<Character,Integer> freq = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(char x: s.toCharArray()){
            if(!freq.containsKey(x)){
                freq.put(x,1);
            }
            freq.put(x,freq.get(x)+1);
        }

        Set<Character> ch = freq.keySet();

        int count = 0;
        freq.put('#',0);

        while(count<s.length()){
            char max = '#';
            for(char c : ch){
                if(freq.get(c)>freq.get(max)){
                    max = c; 
                }
            }
            System.out.println(max);
            for(int i=1;i<freq.get(max);i++){
                sb.append(max);
                count++;
            }
            freq.remove(max);
        }
        return sb.toString();
    }
}
