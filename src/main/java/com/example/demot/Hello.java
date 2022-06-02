package com.example.demot;


import com.example.demot.bean.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hello {
    public static void main(String[] args) {
        //Test1();
        Test3();
        /*System.out.println("new 2");
        System.out.println("我是分支dev");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是匿名类");
            }
        };
        r.run();
        Runnable r2 =() -> System.out.println("lambda表达式");

        Comparator<Integer> comparator = (o1,o2) -> o1-o2;*/
    }
    /*lambda表达式测试*/
    public  static void  Test1() {
        /*消费型接口*/
        Consumer<Integer> consumer = s -> System.out.println(s);
        consumer.accept(8);
        /*供给型接口*/
        Supplier<String> provider = () -> "供给型";
        System.out.println(provider.get());
        /*函数型接口*/
        Function<Integer,String> function = t -> t+"ss";
        System.out.println(function.apply(10));
        /*判断接口*/
        Predicate<Integer> predicate = s -> s > 5;
        System.out.println(predicate.test(10));
    }

     public static void  Test2() {
        //创建stream
          //集合
         List<Student> list = new ArrayList<>();
         list.add(new Student("李四",18,"男"));
         list.add(new Student("李5",18,"NV"));
         list.add(new Student("李5",18,"NV"));
         list.add(new Student("李7",19,"男"));
         //顺序流
         Stream<Student> stream = list.stream();
         //并行流
/*         Stream<Student> studentStream = list.parallelStream();
       //数组
         int[] arr = new int[]{1,2,3,4,5,6,7,8,9,5,5};
         IntStream stream1 = Arrays.stream(arr);
      //stream of
         Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);*/

         /*中间操作  */
         //filter(Predicate) 过滤   参数函数式接口
         stream.filter(stu -> stu.getAge() > 18 ).forEach(System.out::println);
         //limit 截断流
         list.stream().limit(2).forEach(System.out::println);
         //skip 截断流
         list.stream().skip(2).forEach(System.out::println);
         //distinct 筛选重复 调用hash 跟  equase
         list.stream().distinct().forEach(System.out::println);

     }
     //steam 映射
     public static void Test3() {
        /* //集合
         List<Student> list = new ArrayList<>();
         list.add(new Student("李四",18,"男"));
         list.add(new Student("李5",18,"NV"));
         list.add(new Student("李5",18,"NV"));
         list.add(new Student("李7",19,"男"));
         //顺序流
         Stream<Student> stream = list.stream();
         //stream.map(s -> "男".equals(s.getSex())?s:null).forEach(System.out::println);
         int reduce = Arrays.stream(new int[]{1, 2, 3, 5, 686, 8, 64, 6, 8}).reduce(Integer::sum).getAsInt();
         System.out.println(reduce);*/
         HashMap<String,String> hashMap = new HashMap<>();
         hashMap.put("key","value");
         hashMap.put("key2","value2");
         hashMap.put("key3","value3");
         hashMap.put("key4","value4");
         for (String s : hashMap.keySet()) {
             System.out.println(hashMap.get(s));
         }
         /*第二种*/
         System.out.println("...........................................");
         Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
         while (iterator.hasNext()) {
             Map.Entry<String, String> next = iterator.next();
             System.out.println(next.getKey()+": "+next.getValue());
         }
     }
}
