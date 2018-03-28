package sorting;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class AbstractSorting {

    private Random random = new Random();

    Integer[] generateArrays(int num){
        return Stream.generate(() -> random.nextInt(10000)).limit(num).collect(Collectors.toList()).toArray(new Integer[]{});
    }
}
