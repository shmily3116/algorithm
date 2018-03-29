package sorting;

public class SelectionSorting extends AbstractSorting {

    protected Integer[] actualSort(Integer[] toSortArr){
        for (int i=0;i<toSortArr.length - 1;i++){
            int min = i;
            for (int j=i+1;j<toSortArr.length;j++){
                if (toSortArr[j] < toSortArr[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp = toSortArr[min];
                System.arraycopy(toSortArr, i, toSortArr, i + 1, min - i);
                toSortArr[i] = temp;
            }
        }
        return toSortArr;
    }
}
