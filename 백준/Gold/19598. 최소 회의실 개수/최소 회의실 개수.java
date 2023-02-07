import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Queue<Room> input = new PriorityQueue<>();

    static class Room implements Comparable<Room> {
        int start;
        int end;

        Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Room room) {
            return Integer.compare(this.start, room.getStart());
        }
    }

    // solution method
    static void solution() {
        int answer = 0;
        Queue<Room> checkRoom = new PriorityQueue<>(Comparator.comparingInt(Room::getEnd));

        while (!input.isEmpty()) {
            Room nextTime = input.poll();
            checkRoom.offer(nextTime);
            while (!input.isEmpty() && input.peek().getStart() == nextTime.getStart()) {
                checkRoom.offer(input.poll());
            }
            while (!checkRoom.isEmpty() && checkRoom.peek().getEnd() <= nextTime.getStart()) {
                checkRoom.poll();
            }
            answer = Math.max(answer, checkRoom.size());
        }

        System.out.println(answer);
    }

    // coding test run
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            input.offer(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        solution();
    }
}
