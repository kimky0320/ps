import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Mst {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v,e;
    static int[] parent;
    static Queue<Node> queue;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);

        parent = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        queue = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int node1 = Integer.parseInt(s[0]) - 1;
            int node2 = Integer.parseInt(s[1]) - 1;
            int dist = Integer.parseInt(s[2]);
            queue.add(new Node(node1, node2, dist));
        }

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int pa = find(node.node1);
            int pb = find(node.node2);
            if(pa==pb) continue; //사이클 생성하므로 건너뜀

            ans += node.dist;
            union(pa, pb);
        }

        System.out.println(ans);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        parent[pa] = pb;
    }

    static int find(int x) {
        if(x==parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    static class Node implements Comparable<Node>{
        int node1;
        int node2;
        int dist;

        public Node(int node1, int node2, int dist) {
            this.node1 = node1;
            this.node2 = node2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
