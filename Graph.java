import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Integer> queue;
    static Stack<Integer> stack;
    static boolean[] flag;
    static int n,m,v;

    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]) - 1;

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int node1 = Integer.parseInt(s[0]) - 1;
            int node2 = Integer.parseInt(s[1]) - 1;

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        ArrayList<Integer> dfs = dfs();
        ArrayList<Integer> bfs = bfs();

        for (int node : dfs) System.out.print(node + 1 + " ");
        System.out.println();
        for (int node : bfs) System.out.print(node + 1 + " ");
    }

    static ArrayList<Integer> bfs() {
        ArrayList<Integer> bfs = new ArrayList<>();
        queue = new LinkedList<>();
        flag = new boolean[n];
        queue.add(v);

        while (!queue.isEmpty()) {
            int node = queue.remove();
            if(flag[node]) continue;
            flag[node] = true;
            bfs.add(node);

            Queue<Integer> pq = new PriorityQueue<>();
            for (int i : arr[node]) {
                if(flag[i]) continue;
                pq.add(i);
            }
            while(!pq.isEmpty()) queue.add(pq.remove());
        }

        return bfs;
    }

    static ArrayList<Integer> dfs() {
        ArrayList<Integer> dfs = new ArrayList<>();
        stack = new Stack<>();
        flag = new boolean[n];
        stack.add(v);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if(flag[node]) continue;
            flag[node] = true;
            dfs.add(node);

            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : arr[node]) {
                if(flag[i]) continue;
                pq.add(i);
            }
            while(!pq.isEmpty()) stack.add(pq.remove());
        }

        return dfs;
    }
}
