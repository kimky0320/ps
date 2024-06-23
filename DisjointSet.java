import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DisjointSet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                int num = Integer.parseInt(s[j]);
                if (num == 1) {
                    union(i, j);
                }
            }
        }

        String[] s = br.readLine().split(" ");
        int group = find(Integer.parseInt(s[0]) - 1);
        boolean flag = true;
        for (int i = 1; i < s.length; i++) {
            if (find(Integer.parseInt(s[i]) - 1) != group) {
                flag = false;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        parent[bp] = ap;
    }

    static int find(int x) {
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
}
