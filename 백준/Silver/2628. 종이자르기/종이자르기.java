import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> lst_row = new ArrayList<Integer>();
		ArrayList<Integer> lst_height = new ArrayList<Integer>();
		lst_row.add(0); lst_row.add(row); lst_height.add(0); lst_height.add(height); 
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int temp = Integer.parseInt(st.nextToken()); 
			if(temp == 0)
				lst_height.add(Integer.parseInt(st.nextToken()));
			else if(temp == 1)
				lst_row.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(lst_row); Collections.sort(lst_height);
		
		int row_max = -1, height_max = -1;
		for(int i = 0; i<lst_row.size()-1; i++) {
			if(row_max < lst_row.get(i+1)-lst_row.get(i))
				row_max = lst_row.get(i+1)-lst_row.get(i);
		}
		
		for(int i = 0; i<lst_height.size()-1; i++) {
			if(height_max < lst_height.get(i+1)-lst_height.get(i))
				height_max = lst_height.get(i+1)-lst_height.get(i);
		}
		
		System.out.println(row_max*height_max);
	}
}

