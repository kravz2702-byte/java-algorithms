import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

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

    static TreeSet<Integer> nodesSet = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nodesAndEdges = reader.readLine().split(" ");

        Integer nodes = Integer.valueOf(nodesAndEdges[0]);
        Integer edges = Integer.valueOf(nodesAndEdges[1]);
        for (int i = 0; i < edges; i++) {
            String[] twoNodes = reader.readLine().split(" ");
            parseNodes(twoNodes);
        }
        reader.close();
        System.out.println(nodesSet.size());
        Object[] elements = nodesSet.toArray();
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i]);
            if(i < elements.length - 1){
                System.out.print(" ");
            }
        }
        writer.close();
    }

    private static void parseNodes(String[] twoNodes){
        nodesSet.add(Integer.parseInt(twoNodes[0]));
        nodesSet.add(Integer.parseInt(twoNodes[1]));
    }
}
