import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> myCallable = new MyCallable();

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final Future<Integer> task1 = threadPool.submit(myCallable);
        final Future<Integer> task2 = threadPool.submit(myCallable);
        final Future<Integer> task3 = threadPool.submit(myCallable);
        final Future<Integer> task4 = threadPool.submit(myCallable);
        final Integer res = task1.get()+task2.get()+task3.get()+task4.get();
        System.out.printf("Выведено в консоль %d сообщений с содержанием \"Всем привет\".\n", res);

        //Используем invokeAny
//        Integer task5 = threadPool.invokeAny(List.of(myCallable));
//        System.out.printf("Выведено в консоль %d сообщений с содержанием \"Всем привет\".\n", task5);

        threadPool.shutdown();

    }
}