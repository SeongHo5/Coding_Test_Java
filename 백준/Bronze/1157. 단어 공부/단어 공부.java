import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next().toUpperCase();
        int[] counts = new int[26];
        for (char c : s.toUpperCase().toCharArray()) {
            counts[c - 'A']++;
        }

        int maxCount = 0;
        char answer = '?';
        for (int i = 0; i < 26; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                answer = (char) (i + 'A');
            } else if (counts[i] == maxCount) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}