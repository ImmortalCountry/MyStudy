package com.sdy.test;

import com.google.common.collect.Lists;
import com.sdy.javaeight.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: sundy
 * @date: 2020/4/28 22:30
 * @description:
 */
public class Main {
    private Logger logger = LoggerFactory.getLogger(Main.class);

    private static boolean initFlag = false;

    private static Test test = new Test();

    private static int counter = 0;

    public static void refresh(){
        System.out.println("refresh data begin");
        initFlag = true;
        System.out.println("refresh data end");
    }

    public static void main(String[] args) throws Exception{


        Thread thread = new Thread(()->{
            for (;!initFlag;){
                // test.co;
            };
            System.out.println("嗅探到变化，线程结束");
        });

        thread.start();

        Thread.sleep(100);

        Thread b = new Thread(()->{
            refresh();
        });
        b.start();

        Thread c = new Thread(()->{
            for (int i = 0; i < 10; i++) {

            }
        });
        c.start();
        System.out.println("sout");
        if (initFlag){
            System.out.println("ok");
        }
    }

//     @Test
//     public void main() {
//
// //        System.out.println(Long.valueOf("300007867 "));
// //        HashMap<Object, Object> map = new HashMap<>();
// //        map.put(1,"1");
// //        Object o = map.get(1);
// //
// //        System.out.println(o);
// //        System.out.prjiintln("1".equals(o));
// //        ThreadLocal<Object> local = new ThreadLocal<>();
// //        Thread thread = new Thread();
//
// //        TestBookCallBack testBookCallBack = new TestBookCallBack();
// //        testBookCallBack.test(new ICallBack() {
// //            @Override
// //            public void execute() {
// //                System.out.println("Anonymous Inner Class");
// //            }
// //        });
//
// //        BookCallBack bookCallBack = new BookCallBack();
// //        testBookCallBack.test(bookCallBack);
// //        List<String> tentands = Lists.newArrayList("1","2","3","4","5","6");
// //        List<String> re = Lists.newArrayList("2","4","6");
// //        tentands.parallelStream().forEach(t->{
// //            if (re.contains(t)){
// //                return;
// //            }
// //            System.out.println(t);
// //        });
// //        if(T1.isTrue()){researchDevelopmentCenter
// //            System.out.println("ok");
// //        }
//
// //        List<String> list = new ArrayList<>();
// //        list.add("1");
// //        list.add("2");
// //        list.add("3");
// //        List<String> collect = list.stream().filter(x -> x.equals("1")).collect(Collectors.toList());
// //        collect.set(0, "6");
// //        System.out.println(collect);
// //        System.out.println(list);
// //        ArrayList<String> array = new ArrayList<>();
// //        ArrayList<String> array1 = new ArrayList<>(2);
// //        array1.set(0, "1");
// //        array1.add("1");
// //        array1.add(1,"2");
// //        array1.get(1);objectDataId
// //        array.add("2");
// //        array1.add("1");
// //        array1.remove(1);
// //        array1.remove("1");
//
// //        Vector<Integer> vector = new Vector<>();
// //        vector.add(1);
// //        vector.get(1);
// //        Vector<Integer> vector1 = new Vector<>(2);
// //        HashMap<String, Integer> hashMap = new HashMap<>();
// ////        HashMap<String, Integer> hashMap1 = new HashMap<>(2);
// //        hashMap.put("key", 1);
// //        System.out.println(hashMap.get("1"));
// //        hashMap.remove("key");
// //
// //        List<Integer> list = new ArrayList<>();
// //        list.forEach(x->{d
// //
// //        });
//
// //        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
// //        ConcurrentHashMap<Object, Object> map1 = new ConcurrentHashMap<>(2);
// //        map.put("key", "vaule");
// //        map.get("key");
// //        System.out.println(this.getClass());
// //        Integer.parseInt("12-2");
// //        System.out.println(7.0/10);
// //        int t1 = 100000;
// //        int t2 = 100000;
// //        System.out.println(t1 * t2);
// //        System.out.println(t1 * t2 / 1000000);
// //        System.out.println(10 1);
// //        System.out.println(0.1 + 0.2);
// //        System.out.println(1.0 - 0.8);
// //        System.out.println(4.015 * 100);
// //        System.out.println(123.3 / 100);
// //        double amount1 = 2.15;
// //        double amount2 = 1.10;
// //        if (amount1-amount2 == 1.05) {
// //            System.out.println("OK");
// //        }
// //        int[] arr = {1, 2, 3};
// //        final List<int[]> list = Arrays.asList(arr);
// //        logger.info("list:{}, size:{}, class:{}", list, list.size(), list.get(0).getClass());
// //        final List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
// //        logger.info("list:{}, size:{}, class:{}", collect, collect.size(), collect.get(0).getClass());
// //        Integer[] arrInteger = {1,2,3};
// //        final List<Integer> asList = Arrays.asList(arrInteger);
// //        logger.info("list:{}, size:{}, class:{}", asList, asList.size(), asList.get(0).getClass());
//
// //        String[] arr = {"1","2","3"};
// //        List<String> list = Arrays.asList(arr);
// //        arr[1] = "4";
// //        try {
// //            list.add("5");
// //        } catch (Exception e) {
// //            e.printStackTrace();
// //        }
// //        logger.info("arr:{}, list:{}", Arrays.asList(arr), list);
// //        List<List<Integer>> data = new ArrayList<>();
// //        for (int i = 0; i < 1000; i++) {
// //            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
// //            data.add(rawList.subList(0,1));
// //        }
// //        List<Integer> list = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
// //        List<Integer> subList = list.subList(1,4);
// //        System.out.println(subList);
// //        subList.remove(1);
// //        System.out.println(list);
// //        list.add(0);
// //        try {
// //            subList.forEach(System.out::println);
// //        } catch (Exception e) {
// ////            e.printStackTrace();
// ////        }
// //
// //        int elementCount = 100000;
// //        int loopCount = 100000;
// //        StopWatch stopWatch = new StopWatch();
// //        stopWatch.start("linkedListGet");
// //        linkedListGet(elementCount, loopCount);
// //        stopWatch.stop();
// //        stopWatch.start("arrayListGet");
// //        arrayListGet(elementCount, loopCount);
// //        stopWatch.stop();
// //        System.out.println(stopWatch.prettyPrint());
// //
// //        StopWatch stopWatch2 = new StopWatch();
// //        stopWatch2.start("linkedListAdd");
// //        linkedListAdd(elementCount, loopCount);
// //        stopWatch2.stop();
// //        stopWatch2.start("arrayListAdd");
// //        arrayListAdd(elementCount, loopCount);
// //        stopWatch2.stop();
// //        System.out.println(stopWatch2.prettyPrint());
// //        System.out.println(A.getA() == B.getB());
// //        System.out.println(Charset.defaultCharset());
// //        Map<Integer, Integer> map = new ConcurrentHashMap<>();
// //        Map<Integer, Integer> map1 = new HashMap<>();
// //        StopWatch stopWatch = new StopWatch();
// //        ArrayList<Integer> list = Lists.newArrayList();
// //        for (int i = 0; i < 10000000; i++) {
// //            list.add(i);
// //        }
// //        stopWatch.start("currentHashMap");
// //
// //        list.stream().parallel().forEach(x -> map.put(x, 1));
// //        stopWatch.stop();
// //        stopWatch.start("normal for ");
// //        for (int i = 0; i < 10000000; i++) {
// //            map1.put(i, 1);
// //        }
// //        stopWatch.stop();
// //        System.out.println(stopWatch.prettyPrint());
// //        System.out.println(map.size());
// //        System.out.println(map1.size());
// //        Map<Integer, Integer> map1 = new HashMap<>();
// //
// //        for (int i = 0; i < 100000000; i++) {
// //            map1.put(i, 1);
// //        }
// //        Boolean s = null;
// //        if (s){
// //            System.out.println("ok");
// //        }
//
//
// //        String json = "[{\"ext\":\"png\",\"path\":\"N_202009_27_81457af1ff6c47ea9758457969fe9d9e.png\",\"filename\":\"Screenshot_2020-09-27-11-05-26-375_io.dcloud.UNI3BFFF09.png\",\"create_time\":1601176013235,\"size\":522820}]";
// //        Gson gson = new Gson();
// //        final List map = (List<Map>)gson.fromJson(json, List.class);
// //        System.out.println(map);
// //        System.out.println(gson.toJson(map))
//
// //        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
// //        for (URL urL : urLs) {
// //            System.out.println(urL);
// //        }
// //        System.out.println("------- extClassLoader");
// //        URLClassLoader extClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader().getParent();
// //        URL[] extUrls = extClassLoader.getURLs();
// //        for (URL extUrl : extUrls) {
// //            System.out.println(extUrl);
// //        }
// //
// //        System.out.println("------- appClassLoader");
// //        URLClassLoader appClassLoader = (URLClassLoader) Thread.c urrentThread().getContextClassLoader();
// //        URL[] appUrls = appClassLoader.getURLs();
// //        for (URL appUrl : appUrls) {
// //            System.out.println(appUrl);
// //        }
//
// //        List<User> trees = new ArrayList<>();
// //        trees.add(new User("u1", "1", ""));
// //        trees.add(new User("u2", "2", "1"));
// //        trees.add(new User("u3", "3", "1"));
// //        trees.add(new User("u4", "4", "2"));
// //        trees.add(new User("u5", "5", "2"));
// //        trees.add(new User("u6", "6", "2"));
// //        User root = new User("u1", "1", "");
// //        buildTree(root, trees);
// ////        List<User> list = bfs(root.getChildren());
// //        Map<User, Integer> depthMap = Maps.newHashMap();
// //        getDepth(root, 0, depthMap);
// //
// //        A a = new A();
// //        B b = new B();
// //        Integer.valueOf(null);
// //        String ABc;
// //        String abc;
// //        String str = "10,78060:20|78532:30";
// //        String[] groups = str.split("\\|");
// //        for (String group : groups) {
// //            String[] kv = group.split(":");
// //            List<String> tenantIds = Arrays.asList(kv[0].split(","));
// //        }
// //         List<String> list = new ArrayList<>();
// //         List<String> collect = list.stream().collect(Collectors.toList());
// //         System.out.println(collect);
//
//         // private static int i = 0;
//         //
//         // private synchronized void add() {
//         //     i++;
//         // }
//         //
//         //
//         // @Override
//         // public void run() {
//         //     for (int j = 0; j < 1000000; j++) {
//         //         add();
//         //     }
//         // }
//         //
//         // private void add2() {
//         //     synchronized (Test2.class) {
//         //         i++;
//         //     }
//         // }
//         //
//         // public static void main(String[] args) throws Exception {
//         //     Thread t1 = new Thread(new Test2());
//         //     Thread t2 = new Thread(new Test2());
//         //
//         //     t1.start();
//         //     t2.start();
//         //
//         //     t1.join();
//         //     t2.join();
//         //
//         //     System.out.println(i);
//         // }
//     }

    public static void getDepth(User tree, int depth, Map<User, Integer> map) {
        List<User> children = tree.getChildren();
        if (CollectionUtils.isEmpty(children)) {
            map.put(tree, depth);
            return;
        }
        for (User child : children) {
            getDepth(child, depth + 1, map);
        }
    }

    public List<User> bfs(List<User> children) {
        List<User> allChildren = new ArrayList<>();
        List<User> result = Lists.newArrayList();
        List<User> result2 = Lists.newArrayList();
        for (User child : children) {
            System.out.println(child.getName());
            result.add(child);
            List<User> childrenList = child.getChildren();
            if (!CollectionUtils.isEmpty(childrenList)) {
                allChildren.addAll(childrenList);
            }
        }
        if (!CollectionUtils.isEmpty(allChildren)) {
            bfs(allChildren).addAll(result2);
        }
        return result;
    }

    public static void buildTree(User node, List<User> trees) {
        List<User> children = trees.stream().filter(x -> x.getPage().equals(node.getAge())).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(children)) {
            for (User child : children) {
                buildTree(child, trees);
            }
            node.setChildren(children);
        }


//        Map<String, Long> collect = users
//                .stream()
//                .map(User::getName)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        List<String> result = new ArrayList<>();
//        collect.forEach((k,v)->{
//            if(v>1){
//                result.add(k);
//            }
//        });
//        System.out.println(result.toString());

    }

    //LinkedList访问
    private static void linkedListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    //ArrayList访问
    private static void arrayListGet(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.get(ThreadLocalRandom.current().nextInt(elementCount)));
    }

    //LinkedList插入
    private static void linkedListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(LinkedList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount), 1));
    }

    //ArrayList插入
    private static void arrayListAdd(int elementCount, int loopCount) {
        List<Integer> list = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toCollection(ArrayList::new));
        IntStream.rangeClosed(1, loopCount).forEach(i -> list.add(ThreadLocalRandom.current().nextInt(elementCount), 1));
    }
    private static final int RUNS = 100;

    private static final int DIMENSION_1 = 1024 * 1024;

    private static final int DIMENSION_2 = 6;

    private static long[][] longs;

    // public static void main(String[] args) {
    //
    //
    //     longs = new long[DIMENSION_1][];
    //
    //     for (int i = 0; i < DIMENSION_1; i++) {
    //         longs[i] = new long[DIMENSION_2];
    //         for (int j = 0; j < DIMENSION_2; j++) {
    //             longs[i][j] = 1L;
    //         }
    //     }
    //
    //     System.out.println("Array初始化完毕....");
    //
    //     long sum = 0L;
    //     long startTime = System.currentTimeMillis();
    //     for (int i = 0; i < RUNS; i++) {
    //         // 1024 * 1024
    //         for (int j = 0; j < DIMENSION_1; j++) {
    //             for (int k = 0; k < DIMENSION_2; k++) {
    //                 sum += longs[j][k];
    //             }
    //         }
    //     }
    //     long endTime = System.currentTimeMillis();
    //     System.out.println("执行时间：" + (endTime - startTime));
    //     System.out.println("sum:" + sum);
    //
    //     startTime = System.currentTimeMillis();
    //     for (int i = 0; i < RUNS; i++) {
    //         for (int j = 0; j < DIMENSION_2; j++) {
    //             // 1024 * 1024
    //             for (int k = 0; k < DIMENSION_1; k++) {
    //                 sum += longs[k][j];
    //             }
    //         }
    //     }
    //     endTime = System.currentTimeMillis();
    //     System.out.println("执行时间：" + (endTime - startTime));
    //     System.out.println("sum:" + sum);
    // }
}
