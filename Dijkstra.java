import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v,e,k;
    static ArrayList<Node>[] nodes;
    static boolean[] flag;
    static Queue<Node> queue;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        k = Integer.parseInt(br.readLine())-1;

        nodes = new ArrayList[v];
        for (int i = 0; i < v; i++) nodes[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]) - 1;
            int end = Integer.parseInt(s[1]) - 1;
            int dist = Integer.parseInt(s[2]);

            nodes[start].add(new Node(end, dist));
        }

        int[] ans = dijkstra();

        for (int i = 0; i < v; i++) {
            if(ans[i]==INF) System.out.println("INF");
            else System.out.println(ans[i]);
        }
    }

    static int[] dijkstra(){
        int[] dist = new int[v];
        flag = new boolean[v];
        Arrays.fill(dist, INF);

        queue = new PriorityQueue<>();
        queue.add(new Node(k, 0));
        dist[k] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if(flag[node.num]) continue; //이미 최소값 확정됐다면 패스
            flag[node.num] = true;

            for (Node n : nodes[node.num]) {
                if (dist[n.num] > dist[node.num] + n.dist) {
                    dist[n.num] = dist[node.num] + n.dist;
                    queue.add(new Node(n.num, dist[n.num]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node>{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist-o.dist;
        }
    }
}
