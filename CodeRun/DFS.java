import java.io.IOException;
import java.util.*;

public class DFS {

    /*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- int n = Integer.parseInt(reader.readLine());
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
        nums[i] = Integer.parseInt(reader.readLine());
    }
	* последовательность слов в строке --
	String[] parts = reader.readLine().split(" ");

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	int sum = 0;
    String[] parts = reader.readLine().split(" ");
    for (int i = 0; i < parts.length; i++) {
        int num = Integer.parseInt(parts[i]);
        sum += num;
    }
    writer.write(String.valueOf(sum));
	*/
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            // Чтение количества вершин и рёбер
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            // Создаем список смежности для графа
            List<List<Integer>> adjList = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
            
            // Заполняем список смежности
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                
                // Добавляем ребро в список смежности
                // Петли и кратные ребра не влияют на достижимость,
                // но для корректности добавляем их тоже
                adjList.get(u).add(v);
                
                // Для неориентированного графа добавляем обратное ребро
                // (кроме случая петли, где u == v)
                if (u != v) {
                    adjList.get(v).add(u);
                }
            }
            
            // Массив для отметки посещенных вершин
            boolean[] visited = new boolean[n + 1];
            
            // Список для хранения вершин компоненты связности
            List<Integer> component = new ArrayList<>();
            
            // Запускаем поиск в глубину от вершины 1
            dfs(1, adjList, visited, component);
            
            // Сортируем вершины компоненты связности
            Collections.sort(component);
            
            // Выводим результат
            System.out.println(component.size());
            for (int vertex : component) {
                System.out.print(vertex + " ");
            }
        }
    }
    
    // Функция поиска в глубину (DFS)
    private static void dfs(int vertex, List<List<Integer>> adjList, boolean[] visited, List<Integer> component) {
        // Отмечаем вершину как посещенную
        visited[vertex] = true;
        
        // Добавляем вершину в компоненту связности
        component.add(vertex);
        
        // Проходим по всем соседям
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, component);
            }
        } 
    }
}
