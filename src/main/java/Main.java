import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static Object[] filter(Object[] array, Filter filter) {
        int offset = 0;
        List<Object> tmp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!filter.apply(array[i])) offset++;
            else tmp.add(array[i]);
        }
        return tmp.toArray();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt(30);
        Integer array[] = new Integer[size];
        for (int i = 0; i < size; i++) array[i] = random.nextInt(100);
        Object[] newArray = (Object[]) filter(array, new Filter() {
            @Override
            public boolean apply(Object o) {
                return Integer.parseInt(o.toString())%2 == 0;
            }
        });
    }
}