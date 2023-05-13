import java.util.*;

public class A_OverallWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char s[] = scanner.next().toCharArray();
        scanner.close();

        int takahashi = 0;
        int aoki = 0;
        for (int i = 0; i < N; i++) {
            if(s[i] == 'T') {
                takahashi++;
            }
            if(s[i] == 'A') {
                aoki++;
            }
        }

        if (takahashi == aoki) {
            int tCount = 0;
            int aCount = 0;
            for (int j = 0; j < N; j++) {
                if(s[j] == 'T') {
                    tCount++;
                } else if (s[j] == 'A') {
                    aCount++;
                }
                if (tCount == takahashi) {
                    System.out.println("T");
                    System.exit(0);
                } else if (aCount == aoki) {
                    System.out.println("A");
                    System.exit(0);
                }
            }
        }
        else if(takahashi > aoki) {
           System.out.println("T"); 
           System.exit(0);
        } else if(aoki > takahashi) {
            System.out.println("A");  
            System.exit(0);
        }
    }
}

