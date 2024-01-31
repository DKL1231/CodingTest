import java.util.*;

class PointWithRoads{
    public int point;
    public ArrayList<Integer> roadList = new ArrayList<>();
    public int answer = -1;
    public PointWithRoads(int point){
        this.point = point;
    }
    public void AddRoad(int to){
        this.roadList.add(to);
    }    
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        PointWithRoads[] points = new PointWithRoads[n+1];
        for(int i = 1; i<=n; i++) points[i] = new PointWithRoads(i);
        for(int i = 0; i<roads.length; i++){
            points[roads[i][0]].AddRoad(roads[i][1]);
            points[roads[i][1]].AddRoad(roads[i][0]);
        }
        points[destination].answer = 0;
        
        Queue<PointWithRoads> q = new LinkedList<>();
        q.add(points[destination]);
        while(!q.isEmpty()){
            PointWithRoads now = q.poll();
            Iterator<Integer> iterator = now.roadList.iterator();
             while (iterator.hasNext()) {
                 PointWithRoads next = points[iterator.next()];
                 if(next.answer == -1){
                     next.answer = now.answer+1;
                     q.add(next);
                 }
             }
        }
        for(int i = 0; i<sources.length; i++){
            answer[i] = points[sources[i]].answer;
        }
        return answer;
    }
}