package daliy_2022coding.october;

import java.util.LinkedList;
import java.util.Queue;

/*
* 프로그래머스 캐시
* */
public class D20221008_2 {

    static int cacheSize = 3;
    static String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

    // solution method
    static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        for(int i=0; i<cities.length; i++) {
            if(queue.contains(cities[i].toLowerCase())) {
                answer ++;
                queue.remove(cities[i].toLowerCase());
            } else {
                answer += 5;
            }
            queue.offer(cities[i].toLowerCase());
            if(queue.size() > cacheSize)
                queue.poll();
        }

        return answer;
    }

    // coding test run
    public static void main(String[] args) {
        System.out.println(solution(cacheSize, cities));
    }
}
