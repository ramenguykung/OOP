package abstract_interface;

import java.util.*;

public class SubwayRoutePlanner {
    
    static class State {
        int station;
        int line;
        int changes;
        
        public State(int station, int line, int changes) {
            this.station = station;
            this.line = line;
            this.changes = changes;
        }
    }
    
    private int numStations;
    private int numLines;
    private List<List<Integer>> lines;
    private Map<Integer, Set<Integer>> stationToLines;
    
    public SubwayRoutePlanner(int n, int m) {
        this.numStations = n;
        this.numLines = m;
        this.lines = new ArrayList<>();
        this.stationToLines = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            lines.add(new ArrayList<>());
        }
    }
    
    public void addLine(int lineIndex, List<Integer> stations) {
        lines.set(lineIndex, new ArrayList<>(stations));
        
        for (int station : stations) {
            stationToLines.putIfAbsent(station, new HashSet<>());
            stationToLines.get(station).add(lineIndex);
        }
    }
    

    public int findMinChanges(int start, int end) {
        if (start == end) {
            return 0;
        }
        
        if (!stationToLines.containsKey(start) || !stationToLines.containsKey(end)) {
            return -1;
        }
        
        Queue<State> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        
        for (int line : stationToLines.get(start)) {
            State initialState = new State(start, line, 0);
            queue.offer(initialState);
            visited.put(getKey(start, line), 0);
        }
        
        int minChanges = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            if (current.station == end) {
                minChanges = Math.min(minChanges, current.changes);
                continue;
            }
            
            List<Integer> stationsOnCurrentLine = lines.get(current.line);
            for (int nextStation : stationsOnCurrentLine) {
                if (nextStation == current.station) continue;
                
                String key = getKey(nextStation, current.line);
                if (!visited.containsKey(key) || visited.get(key) > current.changes) {
                    visited.put(key, current.changes);
                    queue.offer(new State(nextStation, current.line, current.changes));
                }
            }
            
            if (stationToLines.containsKey(current.station)) {
                for (int newLine : stationToLines.get(current.station)) {
                    if (newLine == current.line) continue;
                    
                    String key = getKey(current.station, newLine);
                    int newChanges = current.changes + 1;
                    
                    if (!visited.containsKey(key) || visited.get(key) > newChanges) {
                        visited.put(key, newChanges);
                        queue.offer(new State(current.station, newLine, newChanges));
                    }
                }
            }
        }
        
        return minChanges == Integer.MAX_VALUE ? -1 : minChanges;
    }
    
    private String getKey(int station, int line) {
        return station + "_" + line;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Enter number of stations (N) and lines (M):");
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            SubwayRoutePlanner planner = new SubwayRoutePlanner(n, m);
            
            System.out.println("Enter stations for each line:");
            for (int i = 0; i < m; i++) {
                System.out.println("Line " + (i + 1) + " - Enter number of stations:");
                int numStationsInLine = scanner.nextInt();
                
                List<Integer> stations = new ArrayList<>();
                System.out.println("Enter station numbers:");
                for (int j = 0; j < numStationsInLine; j++) {
                    stations.add(scanner.nextInt());
                }
                
                planner.addLine(i, stations);
            }
            
            System.out.println("Enter start station (A) and end station (B):");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            
            int result = planner.findMinChanges(start, end);
            
            if (result == -1) {
                System.out.println("impossible");
            } else {
                System.out.println(result);
            }
            
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
