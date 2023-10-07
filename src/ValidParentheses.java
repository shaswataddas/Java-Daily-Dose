import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next ();
            String result = isValid(s) ? "Valid" : "Not Valid" ;
            System.out.println(result);
        }
    }
    private static boolean isValid(String s) {
        int len = s.length();
        ArrayList<Character> parenthesisList = new ArrayList<>();
        int top = -1;

        for(int i=0;i<len;i++){
//            System.out.println(s.charAt(i)+"      "+top);
            if(parenthesisList.size()==0){
                parenthesisList.add(s.charAt(i));
                top += 1;
            }else if(s.charAt(i)==')' && parenthesisList.get(top)=='('){
                parenthesisList.remove(top);
                top -= 1;
            }else if(s.charAt(i)=='}' && parenthesisList.get(top)=='{'){
                parenthesisList.remove(top);
                top -= 1;
            }else if(s.charAt(i)==']' && parenthesisList.get(top)=='['){
                parenthesisList.remove(top);
                top -= 1;
            }else{
                parenthesisList.add(s.charAt(i));
                top += 1;
            }
        }
        return parenthesisList.size() == 0;
    }
}
