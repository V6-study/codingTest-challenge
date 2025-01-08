// https://www.acmicpc.net/problem/3029

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String startStr = br.readLine();
        String[] start = startStr.split(":");
        String endStr = br.readLine();
        String[] end = endStr.split(":");
        if (startStr.equals(endStr)) {
            System.out.println("24:00:00");
        }else{
            int[] answer = new int[3];
            for (int i = 0; i < 3; i++) {
                answer[i] = Integer.parseInt(end[i]) - Integer.parseInt(start[i]);
            }
            if (answer[2] < 0) {
                answer[2]+= 60;
                answer[1]--;
            }
            if (answer[1] < 0) {
                answer[1]+= 60;
                answer[0]--;
            }
            if (answer[0] < 0) {
                answer[0] += 24;
            }
            System.out.format("%02d:%02d:%02d", answer[0], answer[1], answer[2]);
        }




    }
}
