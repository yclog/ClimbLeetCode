import java.util.ArrayList;

public class Valid_Parentheses {
    ArrayList<Character> arrayList=new ArrayList<>();

    public boolean isValid(String s) {
        if (isRight(s.charAt(0)))
            return false;
        if (s.length()%2==1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            arrayList.add(s.charAt(i));
            if (isRight(s.charAt(i))){
                if (isMatch(arrayList.get(arrayList.size()-2),arrayList.get(arrayList.size()-1)))
                    popTwo();
            }
        }
        if (arrayList.size()==0)
            return true;
        else
            return false;
    }

    public void push(char symbol){
        arrayList.add(symbol);
    }

    public void popTwo(){
        arrayList.remove(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
    }

    public boolean isMatch(char Left,char Right){
        if (Left=='{' && Right=='}')
            return true;
        if (Left=='(' && Right==')')
            return true;
        if (Left=='[' && Right==']')
            return true;
        return false;
    }

    public boolean isRight(char symbol){
        if (symbol=='}'||symbol==']'||symbol==')')
            return true;
        return false;
    }
}
