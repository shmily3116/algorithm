package search;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author daojia
 * @date 2018-3-29.
 */
public abstract class AbstractSearch {

    private Random random = new Random();

    public void search(int num){
        Integer[] arrays = dealArrays(generateArrays(num));
        Integer index = random.nextInt(arrays.length);
        Integer target = arrays[index];
        if (random.nextBoolean()){
            target = random.nextInt(20000);
        }
        System.out.println("target array : "+ Arrays.toString(arrays));
        System.out.println("target number: "+ target + ", target index: "+ index);
        Integer targetIndex = actualSearch(arrays, target);
        System.out.println(" found index : "+ targetIndex);
    }

    private Integer[] generateArrays(int num){
        List<Integer> arrays = Stream.generate(() -> random.nextInt(10000)).limit(num).sorted().collect(Collectors.toList());
        return arrays.toArray(new Integer[]{});
    }

    protected Integer[] dealArrays(Integer[] arrays){
        return arrays;
    }

    protected abstract Integer actualSearch(Integer[] arrays, int target);
}
