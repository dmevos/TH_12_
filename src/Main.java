import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    final static int COUNT_TP = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> myCallable = new MyCallable();

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < COUNT_TP; i++) {
            tasks.add(threadPool.submit(myCallable));
        }

        Integer res = 0;
        for (Future<Integer> task : tasks) {
            res += task.get();
        }
        System.out.printf("Выведено в консоль %d сообщений с содержанием \"Всем привет\".\n", res);

        //Используем invokeAny
//        Integer task5 = threadPool.invokeAny(List.of(myCallable));
//        System.out.printf("Выведено в консоль %d сообщений с содержанием \"Всем привет\".\n", task5);

        threadPool.shutdown();

    }
}