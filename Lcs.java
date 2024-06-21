import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lcs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] lcs;

    public static void main(String[] args) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();

        lcs = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else lcs[i][j] = Integer.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        System.out.println(lcs[s1.length()][s2.length()]);
    }
}
