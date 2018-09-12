package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
    List<Entry> entries = new ArrayList<>();
    int position = 0;
    int lastValue = 0;
    public StockSpanner() {

    }

    public int next(int price) {
        position++;
        if (price <= lastValue){
            entries.add(new Entry(position, price));
        } else {

        }
        lastValue = price;
    }

    class Entry{
        int pos;
        int value;
        public Entry(int pos, int value){
            this.pos = pos;
            this.value = value;
        }
    }
}
