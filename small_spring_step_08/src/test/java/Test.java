import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author lints
 * @Date 2022/5/6
 * @Descirption
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(20);
        list.add(9);
        list.add(76);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
    }
}
