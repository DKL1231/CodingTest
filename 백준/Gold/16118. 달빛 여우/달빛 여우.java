import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
	int from, to;
	int w;
	int isOdd;

	public Road(int from, int to, int w) {
		this.from = from;
		this.to = to;
		this.w = w;
	}
	
	public Road(int from, int to, int w, int isOdd) {
		this.from = from;
		this.to = to;
		this.w = w;
		this.isOdd = isOdd;
	}

	@Override
	public int compareTo(Road o) {
		// TODO Auto-generated method stub
		return w-o.w;
	}
	
}

public class Main {
	static int n, m;
	static ArrayList<Road>[] roads;
	static int[][] wolfRoad;
	static int[] foxRoad;
	static boolean[] foxVisit;
	static boolean[][] wolfVisit;
	
	static void init() {
		wolfRoad = new int[2][n+1];
		foxRoad = new int[n+1];
		roads = new ArrayList[n+1];
		foxVisit = new boolean[n+1];
		wolfVisit = new boolean[2][n+1];
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<2; j++) wolfRoad[j][i] = Integer.MAX_VALUE;
			foxRoad[i] = Integer.MAX_VALUE;
			roads[i] = new ArrayList<>();
		}
	}
	
	static void findFox() {
		foxRoad[1] = 0;
		foxVisit[1] = true;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		for(Road r: roads[1]) {
			pq.add(new Road(r.from, r.to, r.w*2));
		}
		
		while(!pq.isEmpty()) {
			Road now = pq.poll();
			if(!foxVisit[now.to]) {
				foxVisit[now.to] = true;
				foxRoad[now.to] = now.w;
				for(Road r: roads[now.to]) {
					if(!foxVisit[r.to])
						pq.add(new Road(r.from, r.to, r.w*2+now.w));
				}
			}
		}
	}
	
	static void findWolf() {
		wolfRoad[0][1] = 0;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		for(Road r: roads[1]) {
			pq.add(new Road(r.from, r.to, r.w, 0));
		}
		
		while(!pq.isEmpty()) {
			Road now = pq.poll();
			if(!wolfVisit[now.isOdd][now.to]) {
				wolfRoad[now.isOdd][now.to] = now.w;
				wolfVisit[now.isOdd][now.to] = true;
				for(Road r: roads[now.to]) {
					if(wolfVisit[Math.abs(now.isOdd-1)][r.to]) continue;
					if(now.isOdd == 0) {
						pq.add(new Road(r.from, r.to, r.w*4+now.w, 1));
					}
					else {
						pq.add(new Road(r.from, r.to, r.w+now.w, 0));
					}
				}
			}
		}
	}
	
	static void printAnswer() {
		for(int i = 1; i<=n; i++) {
			System.out.print(foxRoad[i]+" ");
		}
		System.out.println();
		
		for(int i = 1; i<=n; i++) {
			System.out.print(wolfRoad[0][i]+" ");
		}
		System.out.println();
		for(int i = 1; i<=n; i++) {
			System.out.print(wolfRoad[1][i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		init();
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from, to, w;
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			roads[from].add(new Road(from, to, w));
			roads[to].add(new Road(to, from, w));
		}
		
		findFox();
		findWolf();
		
		int answer = 0;
		for(int i = 2; i<=n; i++) {
			if(foxRoad[i] < Math.min(wolfRoad[0][i], wolfRoad[1][i])) answer++;
		}
		System.out.println(answer);
	}
}
