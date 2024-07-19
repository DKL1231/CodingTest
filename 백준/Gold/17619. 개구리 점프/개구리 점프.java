import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
    int num, start, end;

    public Tree(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Tree o) {
        return start - o.start;
    }
}

public class Main {
    static int n, q;
    static int[] parent;
    static Tree[] trees;
    static PriorityQueue<Tree> pq = new PriorityQueue<>();
    static Queue<Point> questions = new LinkedList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        trees = new Tree[n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int from, to, y;
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            parent[i] = i;
            trees[i] = new Tree(i, from, to);
            pq.offer(trees[i]);
        }

        for(int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            questions.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static void solve() {
        Tree t = pq.poll();
        int nowEnd = t.end;
        int nowIdx = t.num;
        while(!pq.isEmpty()){
            t = pq.poll();
            if(nowEnd >= t.start){
                union(nowIdx, t.num);
                if(nowEnd < t.end){
                    nowEnd = t.end;
                }
            }else{
                nowEnd = t.end;
                nowIdx = t.num;
            }
        }

        while(!questions.isEmpty()){
            Point quest = questions.poll();
            int from = quest.x;
            int to = quest.y;

            if(find(from) == find(to)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    public static int find(int a){
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return;
        }
        if(parent[pa] > parent[pb]){
            parent[pa] = parent[pb];
        }else{
            parent[pb] = parent[pa];
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
