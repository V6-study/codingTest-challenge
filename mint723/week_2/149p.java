import java.util.*;

public class Main {

    public static void main(String[] args) {
//        int decimal = 10;
//        int decimal = 27;
        int decimal = 12345;
        System.out.println(toBinary(decimal));
    }

    static String toBinary(int n) {
        Stack<Integer> stack = new Stack<>();
        while(!(n == 0)){
            stack.push(n%2);
            n/=2;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}

