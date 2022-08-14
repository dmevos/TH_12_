import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        int i = 0;
        try {
            while (i < 5) {
                Thread.sleep(300);
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
                i++;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("Поток %s завершен\n", Thread.currentThread().getName());
        }
        return i;
    }

}
