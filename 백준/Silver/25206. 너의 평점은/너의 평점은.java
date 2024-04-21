import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static Map<String, Double> scoreMap = new HashMap<>();
	static String[] inputGrade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
	static Double[] inputScore = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
	
	static void init() {
		for(int i = 0; i<inputGrade.length; i++) {
			scoreMap.put(inputGrade[i], inputScore[i]);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		init();
		double result = 0;
		double totalTime = 0;
		for(int i = 0; i<20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			double time = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			if(grade.equals("P")) {continue;}
			totalTime+=time;
			result += time*scoreMap.get(grade);
		}
		
		System.out.println(result/totalTime);
	}
}
