package week_12.zoac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Key {
        int row, col;
        boolean isLeft;  // 왼손으로 쳐야하는지 여부

        Key(int row, int col, boolean isLeft) {
            this.row = row;
            this.col = col;
            this.isLeft = isLeft;
        }
    }

    public static void main(String[] args) throws IOException {
        HashMap<Character, Key> keyboard = new HashMap<>();

        // 첫 번째 줄
        keyboard.put('q', new Key(0, 0, true));
        keyboard.put('w', new Key(0, 1, true));
        keyboard.put('e', new Key(0, 2, true));
        keyboard.put('r', new Key(0, 3, true));
        keyboard.put('t', new Key(0, 4, true));
        keyboard.put('y', new Key(0, 5, false));
        keyboard.put('u', new Key(0, 6, false));
        keyboard.put('i', new Key(0, 7, false));
        keyboard.put('o', new Key(0, 8, false));
        keyboard.put('p', new Key(0, 9, false));

        // 두 번째 줄
        keyboard.put('a', new Key(1, 0, true));
        keyboard.put('s', new Key(1, 1, true));
        keyboard.put('d', new Key(1, 2, true));
        keyboard.put('f', new Key(1, 3, true));
        keyboard.put('g', new Key(1, 4, true));
        keyboard.put('h', new Key(1, 5, false));
        keyboard.put('j', new Key(1, 6, false));
        keyboard.put('k', new Key(1, 7, false));
        keyboard.put('l', new Key(1, 8, false));

        // 세 번째 줄
        keyboard.put('z', new Key(2, 0, true));
        keyboard.put('x', new Key(2, 1, true));
        keyboard.put('c', new Key(2, 2, true));
        keyboard.put('v', new Key(2, 3, true));
        keyboard.put('b', new Key(2, 4, false));  // b를 오른손으로 수정
        keyboard.put('n', new Key(2, 5, false));
        keyboard.put('m', new Key(2, 6, false));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char left = st.nextToken().charAt(0);   // 왼손 시작 위치
        char right = st.nextToken().charAt(0);  // 오른손 시작 위치

        String target = br.readLine();
        int time = 0;

        for (char c : target.toCharArray()) {
            Key key = keyboard.get(c);
            if (key.isLeft) {  // 왼손으로 쳐야하는 키
                time += getDistance(keyboard.get(left), key);
                left = c;
            } else {  // 오른손으로 쳐야하는 키
                time += getDistance(keyboard.get(right), key);
                right = c;
            }
            time += 1;  // 키를 누르는 시간 1 추가
        }

        System.out.println(time);
    }

    static int getDistance(Key from, Key to) {
        return Math.abs(from.row - to.row) + Math.abs(from.col - to.col);
    }
}