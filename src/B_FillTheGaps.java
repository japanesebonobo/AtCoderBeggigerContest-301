import java.util.*;

public class B_FillTheGaps  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < A.length-1; i++) {
            if (Math.abs(A[i] - A[i+1]) != 1) {
                A = insert(A[i], A[i+1], A, i);
            }
        }
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    private static int[] insert(int first, int second, int[] A, int firstIndex) {
        int[] head = Arrays.copyOf(A, firstIndex+1);
        int[] tail = Arrays.copyOfRange(A, firstIndex+1, A.length);
        if (first < second) {
            int plus = second - first - 1;
            int[] mid = new int[plus];
            for (int i = 0; i < plus; i++) {
                if (first+(i+1) == second) {
                    break;
                }
                mid[i] = first+(i+1);
            }            
            int []firstHalf = merge(head, mid);
            int []ans = merge(firstHalf, tail);
            return ans;
        } else if (first > second) {
            int minus = first - second - 1;
            int[] mid = new int[minus];
            for (int i = 0; i < minus; i++) {
                if (first-(i+1) == second) {
                    break;
                }
                mid[i] = first-(i+1);
            }
            int []firstHalf = merge(head, mid);
            int []ans = merge(firstHalf, tail);
            return ans;
        }
        return head;
    }

    private static int[] merge(int[] first, int[] second) {
        int ans[] = new int[first.length + second.length];
        System.arraycopy(first, 0, ans, 0, first.length);
        System.arraycopy(second, 0, ans, first.length, second.length);
        return ans;
    }
}

