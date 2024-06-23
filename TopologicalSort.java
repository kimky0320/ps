import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static ArrayList<Integer>[] arr;
    static Queue<Integer> queue;
    static int[] fanIn;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new ArrayList[n];
        fanIn = new int[n];

        for (int i = 0; i < n; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]) - 1;
            int b = Integer.parseInt(s[1]) - 1;
            arr[a].add(b);
            fanIn[b]++;
        }

        queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if(fanIn[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int p = queue.remove();
            System.out.print(p+1 + " ");

            for (int out : arr[p]) {
                fanIn[out]--;
                if(fanIn[out]==0) queue.add(out);
            }
        }
    }
}
