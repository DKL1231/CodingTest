import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Person {
	int x, y;

	public Person(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Person [x=" + x + ", y=" + y + "]";
	}
	
}

class Stair {
	int x, y, time;

	public Stair(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Solution {
	static int[][] map;
	static ArrayList<Person> people = new ArrayList<>();
	static ArrayList<Stair> stairs = new ArrayList<>();
	static ArrayList<Person>[] stairPeople = new ArrayList[2];
	static int answer = Integer.MAX_VALUE;

	static void perm(int depth) {
		if (depth == people.size()) {
			int tmp = Math.max(simulation(0), simulation(1));
//			System.out.println();
//			System.out.println(tmp);
//			System.out.println();
			answer = Math.min(tmp, answer);
			return;
		}
		stairPeople[0].add(people.get(depth));
		perm(depth + 1);
		stairPeople[0].remove(people.get(depth));

		stairPeople[1].add(people.get(depth));
		perm(depth + 1);
		stairPeople[1].remove(people.get(depth));
	}

	static int simulation(int idx) {
		int[] endTime = new int[stairPeople[idx].size()];
		stairPeople[idx].sort(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int a = Math.abs(stairs.get(idx).x - o1.x) + Math.abs(stairs.get(idx).y - o1.y);
				int b = Math.abs(stairs.get(idx).x - o2.x) + Math.abs(stairs.get(idx).y - o2.y);
				return a - b;
			}
		});
		int now = 0;
		for (Person p : stairPeople[idx]) {
			int arriveTime = Math.abs(stairs.get(idx).x - p.x) + Math.abs(stairs.get(idx).y - p.y);
			if (now - 3 >= 0 && endTime[now - 3] > arriveTime) {
				arriveTime = endTime[now - 3]-1;
			}
			endTime[now] = arriveTime + stairs.get(idx).time + 1;
			now++;
		}
//		for(Person person: stairPeople[idx])
//			System.out.print(person+" ");
//		System.out.println();
//		for(int i: endTime)
//			System.out.print(i+" ");
//		System.out.println();
		return now>=1?endTime[now-1]:0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			answer = Integer.MAX_VALUE;
			stairPeople[0] = new ArrayList<>();
			stairPeople[1] = new ArrayList<>();
			people = new ArrayList<>();
			stairs = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						people.add(new Person(i, j));
					else if (map[i][j] > 1)
						stairs.add(new Stair(i, j, map[i][j]));
				}
			}
			perm(0);
			System.out.println("#"+tc+" "+answer);
		}
	}
}