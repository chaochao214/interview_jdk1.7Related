package meituan.hashmap;

import java.util.HashMap;
import org.junit.Test;


//@TestInstance(Lifecycle.PER_CLASS)
public class HashMapInfiniteLoop {  

    private  HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);

    /**
     * @Description
     * @Date 2021/12/1 11:29
     **/
    @Test
    public void testLoop() {
        System.out.println("线程main----");
        map.put(5, "C");
        new Thread("Thread1") {
            public void run() {
                System.out.println("线程1----");
                map.put(7, "B");
                System.out.println("thread1 map  ==>" +map);
            };
        }.start();
        new Thread("Thread2") {
            public void run() {
                System.out.println("线程2----");
                map.put(3, "A");
                System.out.println("thread2 map  ==>" +map);
            };
        }.start();
    }


    /**
     * @Description
     * @Date 2021/12/1 11:33
     **/
    @Test
    public void testLoopThread1() {
        map.put(5, "C");
        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println("thread1 map  ==>" +map);
            };
        }.start();
    }

    @Test
    public void testLoopThread2() {
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println("thread2 map  ==>" +map);
            };
        }.start();
    }


    /**
     * @Description
     * @Date 2021/12/1 10:59
     **/
    @Test
    public void test() {
        HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);
        map.put(5, "C");
        map.put(7, "B");
        map.put(3, "A");
        System.out.println(map);
        // {5=C, 3=A, 7=B}  为什们顺序不同
    }


} 