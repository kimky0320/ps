import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lis {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int t,n, k;
    static int[] days;
    static int[] lis;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);

            days = new int[n];
            lis = new int[n+1];

            s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) days[j] = Integer.parseInt(s[j]);

            int len = 0;
            for (int j = 0; j < n; j++) {
                if (days[j] > lis[len]) {
                    len++;
                    lis[len] = days[j];
                } else {
                    int index = binarySearch(0, len, days[j]);
                    lis[index] = days[j];
                }
            }

            System.out.println("#Case #" + (i + 1));
            if(len>=k) System.out.println(1);
            else System.out.println(0);
        }
    }

    static int binarySearch(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < key) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
