public class Reverse_Integer {
    public static int reverse(int x) {
        boolean sign=true;
        if (x>=Integer.MAX_VALUE||x<=Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            x=Math.abs(x);
            sign=false;
        }

        String result="";
        while(x>=10){
            result=result+x%10;
            x=x/10;
        }
        if (x<10){
            result=result+x;
        }
        if (sign)
            return Long.parseLong(result)>Integer.MAX_VALUE ? 0 : Integer.parseInt(result);
        else
            return -Long.parseLong(result)<Integer.MIN_VALUE ? 0 : -Integer.parseInt(result);
    }
}
