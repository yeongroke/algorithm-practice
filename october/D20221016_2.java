import java.util.*;

public class D20221016_2 {

    static class Pair{
        String x;
        int cnt;
        Pair(String x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

    static String[] input = new String[]{
            "spy","ray","spy","room","once","ray","spy","once"
    };

    static String[] solution(String[] movie) {
        if(movie.length==1) {
            return movie;
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<movie.length;i++){
            if(map.containsKey(movie[i])){
                map.put(movie[i],map.get(movie[i])+1);
            } else {
                map.put(movie[i],0);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((i,j)->{
                    if(map.get(i)==map.get(j)) {
                        return i.compareTo(j);
                    } else {
                        return Integer.compare(map.get(j),map.get(i));
                    }
                }
        );

        return list.toArray(new String[list.size()]);

    }

    public static void main(String[] args) {
        System.out.println(solution(input));
    }
}
