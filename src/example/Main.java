package example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        //dw
        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple(100, "RedApple", "Red"));
        appleList.add(new Apple(150, "BlueApple", "Blue"));
        appleList.add(new Apple(200, "YellowApple", "Yellow"));
        appleList.add(new Apple(250, "RainbowApple", "Rainbow"));

        // 정렬
        Collections.sort(appleList, new Comparator<Apple>() {
            public int compare(Apple p1, Apple p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.print(appleList.stream().filter(i -> i.getWeight() > 100).collect(toList()));


//        Collections.sort(appleList, (p1, p2) -> p1.getName().compareTo(p2.getName()));
//        Collections.sort(appleList, Comparator.comparing(Apple::getName));
//
//        // 쓰레드
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello world one!");
//            }
//        };
//        r1.run();
//
//        Runnable r2 = () -> System.out.println("Hello World one!");
//        r2.run();
//
//        /*
//        *  Stream 예제
//        * */
//        // 이벤트
//        JButton button = new JButton();
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("button click!!!");
//            }
//        });
//
//        button.addActionListener(e -> System.out.println("button click!!!"));
//
//        // 특정 항목 필터링
//        List<Apple> filteringAppleList = new ArrayList<>();
//        for (Apple apple : appleList) {
//            if (apple.getWeight() > 100) {
//                filteringAppleList.add(apple);
//            }
//        }
//
//        // List -> Map로 변환
//        Map<String, Apple> appleMap = new HashMap<>();
//        for (Apple apple : appleList) {
//            appleMap.put(apple.getName(), apple);
//        }
//        appleMap = appleList.stream()
//                .collect(Collectors.toMap(Apple::getName, Function.identity()));
//        System.out.println(appleMap.get("BlueApple"));
//
//        // 중복되지 않은 정보 추출
//        List<Apple> distinctAppleList = new ArrayList<>();
//        for (Apple apple : appleList) {
//            if (!appleList.contains(apple)) {
//                distinctAppleList.add(apple);
//            }
//        }
//
//        List<Apple> distinctApple2List = appleList.stream()
//                .distinct()
//                .collect(toList());
//        distinctApple2List.forEach(System.out::println);
//
//        // 특정항목만 추출
//        List<String> appleNameList = new ArrayList<>();
//        for (Apple apple : appleList) {
//            appleNameList.add(apple.getName());
//        }
//
//        List<String> nameList = appleList.stream()
//                .map(Apple::getName)
//                .collect(toList());
//
//        nameList.forEach(System.out::println);
        //
    }
}
