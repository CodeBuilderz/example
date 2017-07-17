package example.study3;

import java.util.*;
import java.util.stream.Collectors;

public class study3 {

    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 5, 6, 7, 8);

        Optional<Integer> sum2 = numberList.stream()
                .reduce((x , y) -> x * y);
        //*.sorted(Comparator.reverseOrder())

        System.out.println(sum2.get());

        OptionalDouble sum = numberList.stream()
                .distinct()
                .mapToDouble(i -> i)
                .average();
        // .skip(1)
        // .limit(1)

        System.out.println(sum.getAsDouble());



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
