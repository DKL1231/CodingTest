import java.util.*;
class Pair<A, B>{
    private A x;
    private B y;
    public Pair (A a, B b){
        this.x = a;
        this.y = b;
    }
    public A getLeft(){
        return this.x;
    }
    public void setLeft(A a){
        this.x = a;
    }
    public B getRight(){
        return this.y;
    }
    public void setRight(B b){
        this.y = b;
    }
}
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int cnt = -1;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));
        while(!q.isEmpty()){
            Pair<Integer, Integer> now = q.poll();
            int nowIndex = now.getLeft();
            int nowValue = now.getRight();
            if(nowIndex == numbers.length){
                if(nowValue == target)
                    answer++;
                continue;
            }
            q.add(new Pair<>(nowIndex+1, nowValue+numbers[nowIndex]));
            q.add(new Pair<>(nowIndex+1, nowValue-numbers[nowIndex]));
        }
        return answer;
    }
}