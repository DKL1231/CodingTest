import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class Word implements Comparable<Word>{
	String s;
	int cnt, len;
	public Word(String s, int cnt, int len) {
		super();
		this.s = s;
		this.cnt = cnt;
		this.len = len;
	}
	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		if(this.cnt == o.cnt) {
			if(this.len == o.len) {
				return this.s.compareTo(o.s);
			}else {
				return o.len-this.len;
			}
		}else {
			return o.cnt-this.cnt;
		}
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(s);
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if(this == o) return true;
		if(!(o instanceof Word)) return false;
		Word tmp = (Word) o;
		return this.s.equals(tmp.s);
	}

	
}

public class Main {
	static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Map<String, Word> wordMap = new HashMap<>();
		for(int i = 0; i<n; i++) {
			String word = br.readLine();
			int wordLen = word.length();
			if(wordLen < m) continue;
			if(wordMap.keySet().contains(word)) {
				wordMap.get(word).cnt++;
			}else {
				wordMap.put(word, new Word(word, 1, wordLen));
			}
		}
		
		PriorityQueue<Word> pq = new PriorityQueue<>();
		
		for(Word w: wordMap.values()) {
			pq.add(w);
		}
		while(!pq.isEmpty()) {
			sb.append(pq.poll().s+"\n");
		}
		System.out.println(sb.toString());
	}
}