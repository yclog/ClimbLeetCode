import java.util.HashMap;

public class Roman_to_Integer {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        setData(map);
        char[] roman=s.toCharArray();
        int sum=0;
        for (int i = 0; i < roman.length; i++) {
            if (roman.length-1==i){
                sum+=map.get(roman[i]);
            } else if (map.get(roman[i])<map.get(roman[i+1])){
                sum-=map.get(roman[i]);
            } else {
                sum+=map.get(roman[i]);
            }
        }
        return sum;
    }

    public static void setData(HashMap<Character,Integer> map){
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
}
