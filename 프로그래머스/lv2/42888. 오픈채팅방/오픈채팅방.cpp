#include <string>
#include <sstream>
#include <map>
#include <vector>
#define ent "님이 들어왔습니다."
#define lev "님이 나갔습니다."
using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    int rs = record.size();
    map<string, string> m;
    for(int i = 0; i<rs; i++){
        stringstream ss(record[i]);
        vector<string> words;
        string word;
        while (getline(ss, word, ' ')){
            words.push_back(word);
        }
        if(words.size() != 2){
            if(m.find(words[1]) != m.end()){
                m[words[1]] = words[2];
            }else{
                m.insert({words[1], words[2]});
            }
        }
    }
    for(int i = 0; i<rs; i++){
        stringstream ss(record[i]);
        string type, id;
        ss>>type>>id;
        if(type.at(0) == 'E'){
            answer.push_back(m[id]+ent);
        }else if(type.at(0) == 'L'){
            answer.push_back(m[id]+lev);
        }
    }
    return answer;
}