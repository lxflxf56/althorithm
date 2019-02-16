package test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {
        List a;
        Map b;
        Set c;
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        //executorService.invokeAll()

        char d='A';
        int e=d;
        System.out.println(e);

    }
}
