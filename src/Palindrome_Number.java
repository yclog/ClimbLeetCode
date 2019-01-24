public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        StringBuffer mStringBuffer=new StringBuffer(String.valueOf(x));
        return mStringBuffer.subSequence(0,mStringBuffer.length()/2).
                equals(mStringBuffer.reverse().subSequence(0,mStringBuffer.length()/2)) ? true:false;
    }
}
