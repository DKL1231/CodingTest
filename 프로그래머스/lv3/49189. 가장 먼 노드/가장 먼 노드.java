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
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int[] x: edge){
            graph.get(x[0]).add(new Edge(x[1], 1));
            graph.get(x[1]).add(new Edge(x[0], 1));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        
        pQ.offer(new Edge(1, 0));
        dis[1] = 0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) continue;
            for(Edge ob: graph.get(now)){
                if(dis[ob.vex]>nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, dis[ob.vex]));
                }
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++)
            if(dis[i]>mx){
                mx = dis[i];
                answer = 1;
            }else if(dis[i] == mx){
                answer++;
            }
        return answer;
    }
}