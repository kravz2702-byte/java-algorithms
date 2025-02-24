import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Дан неориентированный граф, возможно с петлями и кратными ребрами. 
Необходимо найти компоненту связности, содержащую вершину с номером 1.

В первой строке записаны два целых числа — количество вершин и ребер в графе.

В последующих M строках перечислены ребра — пары чисел, определяющие номера вершин, которые соединяют ребра.
Вершины нумеруются с единицы.

Формат вывода
В первой строке выведите число K — количество вершин в компоненте связности.
Во второй строке выведите K целых чисел — вершины компоненты связности, перечисленные в порядке возрастания номеров.


*/

//TODO rewrite
public class SearchinDepth {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, List<Integer>> graph = new HashMap<>();

        //Numbers of vertexes and edges
        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        //Input of Edges
        for (int i = 0; i < M; i++) {
            String[] twoEdges = reader.readLine().split(" ");
            int u = Integer.valueOf(twoEdges[0]);
            int v = Integer.valueOf(twoEdges[1]);

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //Set for visited nodes monitoring
        Set<Integer> visited = new HashSet<>();
    
        //List to save componet of connectivity
        List<Integer> component = new ArrayList<>();

        if (graph.containsKey(1)) {
            dfs(1, graph, visited, component);
        }

        Collections.sort(component);

        System.out.println(component.size());
        for (int vertex: component) {
            System.out.print(vertex+ " ");
        }

        reader.close();
        writer.close();
    }

    private static void dfs(int v, Map<Integer, List<Integer>> graph, 
                            Set<Integer> visited, List<Integer> component){
        visited.add(v);
        component.add(v);

        for(int neighbor: graph.get(v)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, graph, visited, component);
            }
        }        
    }
}
