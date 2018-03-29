package sorting;

public class InsertionSorting extends AbstractSorting {

    protected Integer[] actualSort(Integer[] toSortArr){
        for (int i=1;i<toSortArr.length;i++){
            int temp = toSortArr[i], j=i-1;
            while(j >= 0 && temp < toSortArr[j]){
                j--;
            }
            System.arraycopy(toSortArr, j+1, toSortArr, j+2, i-j-1);
            toSortArr[j+1] = temp;
        }
        return toSortArr;
    }
}
