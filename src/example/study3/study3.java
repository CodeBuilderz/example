package example.study3;

import example.Apple;

import java.util.*;
import java.util.stream.Collectors;

public class study3 {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 8);

        numberList.stream()
                .reduce((x , y) -> x + y)
                .ifPresent(v -> System.out.println("sum2 = " + v));
        //*.sorted(Comparator.reverseOrder())

        numberList.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .ifPresent(s -> System.out.println("average = " + s));
        // .skip(1)
        // .limit(1)


        List<Apple> appleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            appleList.add(new Apple(i, "사과_" + i, "색깔_" + i));
        }

        /*Random random = new Random();

        List<Integer> rateList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            rateList.add(random.nextInt(100) + 1);
        }

        rateList.forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println();

        int randomValue = result1(random, rateList);

        result2(rateList, randomValue);*/
    }

    private static int result1(Random random, List<Integer> rateList) {
        List<Integer> orderedRate = rateList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        orderedRate.forEach(System.out::println);
        System.out.println("list size : " + orderedRate.size());

        int randomValue = random.nextInt(100) + 1;
        System.out.println("random value = " + randomValue);

        int result = orderedRate.stream().distinct().filter(e -> e >= randomValue).findAny().get();
        System.out.println("result : " + result);
        return randomValue;
    }

    private static void result2(List<Integer> rateList, int randomValue) {
        Optional<Integer> result2 = rateList.stream()
                .sorted(Comparator.naturalOrder())
                .distinct()
                .filter(e -> e >= randomValue)
                .findFirst();


        if (result2.isPresent()) {
            System.out.println("result2 = " + result2.get());
        }
    }


}
