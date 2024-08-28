import java.util.*;

class Word{
    String word;
    ArrayList<Word> next = new ArrayList<>();
    
    public Word(String word){
        this.word = word;
    }
}

class Solution {
    HashMap<String, Word> wordMap = new HashMap<>();
    Set<Word> visit = new HashSet<>();
    
    public int solution(String begin, String target, String[] words) {
        wordMap.put(begin, new Word(begin));
        wordMap.put(target, new Word(target));
        for(String s: words){
            wordMap.put(s, new Word(s));
        }
        makeMap(begin, target, words);
        int answer = bfs(begin, target);
        return answer;
    }
    
    public int bfs(String begin, String target){
        int count = 0;
        
        Queue<Word> q = new LinkedList<>();
        
        q.offer(wordMap.get(begin));
        visit.add(wordMap.get(begin));
        
        while(!q.isEmpty()){
            int qs = q.size();
            while(qs-- != 0){
                Word now = q.poll();
                if(now.word.equals(target)){
                    return count;
                }
                for(Word w: now.next){
                    if(visit.contains(w)){
                        continue;
                    }
                    visit.add(w);
                    q.offer(w);
                }
            }
            count++;
        }
        return 0;
    }
    
    public void makeMap(String begin, String target, String[] words){
        char[] beginArr = begin.toCharArray();
        for(String s: words){
            char[] tmpArr = s.toCharArray();
            
            int beginDiffer = 0;
            for(int i = 0; i<beginArr.length; i++){
                if(beginArr[i] != tmpArr[i]){
                    beginDiffer++;
                }
            }
            if(beginDiffer == 1){
                wordMap.get(begin).next.add(wordMap.get(s));
                wordMap.get(s).next.add(wordMap.get(begin));
            }
        }
        
        for(int i = 0; i<words.length; i++){
            for(int j = i+1; j<words.length; j++){
                char[] word1 = words[i].toCharArray();
                char[] word2 = words[j].toCharArray();
                
                int differ = 0;
                for(int k = 0; k<word1.length; k++){
                    if(word1[k] != word2[k]){
                        differ++;
                    }
                }
                if(differ == 1){
                    wordMap.get(words[i]).next.add(wordMap.get(words[j]));
                    wordMap.get(words[j]).next.add(wordMap.get(words[i]));
                }
            }
        }
    }
}