import java.util.*;
class Edge implements Comparable<Edge>{
	public int vex;
	public int cost;
	Edge(int vex, int cost){
		this.vex = vex;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge ob) {
		return this.cost-ob.cost;
	}
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			graph.add(new ArrayList<Edge>());
		}
		int[] dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int[] x: road) {
			graph.get(x[0]).add(new Edge(x[1], x[2]));
            graph.get(x[1]).add(new Edge(x[0], x[2]));
		}
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		pQ.offer(new Edge(1, 0));
		dis[1] = 0;
		while(!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost>dis[now]) continue;
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex]>nowCost+ob.cost) {
					dis[ob.vex] = nowCost+ob.cost;
					pQ.offer(new Edge(ob.vex, dis[ob.vex]));
				}
			}
		}
        for(int i = 1; i<=N; i++)
            if(dis[i] <= K) answer++;
        return answer;
    }
}