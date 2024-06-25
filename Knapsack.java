import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        ans = new int[n+1][k + 1];

        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            int weight = Integer.parseInt(s[0]);
            int value = Integer.parseInt(s[1]);

            for (int j = 1; j <= k; j++) {
                if (j < weight) {
                    ans[i][j] = ans[i - 1][j];
                } else {
                    ans[i][j] = Integer.max(ans[i-1][j], ans[i-1][j - weight] + value);
                }
            }
        }
        System.out.println(ans[n][k]);
    }
}
