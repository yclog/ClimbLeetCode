import java.util.HashMap;

public class MaxSubstring_Without_Repeating_Characters {
    public static void main(String args[]){
        String mString="abba";
        System.out.println(lengthOfLongestSubstring(mString));
    }

    public static int lengthOfLongestSubstring(String mString) {
        int max=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        if (mString == null) {
            return 0;
        }
        for (int rightIndex=0,leftIndex=0; rightIndex < mString.length(); rightIndex++) {
            if (map.containsKey(mString.charAt(rightIndex))){
                leftIndex=Math.max(leftIndex,map.get(mString.charAt(rightIndex))+1);
            }
            map.put(mString.charAt(rightIndex),rightIndex);
            max=Math.max(max,rightIndex-leftIndex+1);
        }
        return max;
    }
}
