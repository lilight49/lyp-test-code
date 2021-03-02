package collectionTest;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @author liyunpeng
 * @date 2021/3/1 15:17
**/
public class StreamTest {
    public static void main(String[] args) {
        //字符串拼接
        appendString();



    }

    /**
     * @methodName appendString
     * @description 字符串拼接
     * @author liyunpeng
     * @date 2021/3/2 10:11
     * @return: void
    **/
    private static void appendString() {
        List<BO> boList = new ArrayList<BO>();
        BO one = new BO().create("1","耕");
        BO four = new BO().create("1","耕");
        BO two = new BO().create("2","种");
        BO three = new BO().create("3","收");
        boList.add(three);
        boList.add(two);
        boList.add(one);
        boList.add(four);

        boList.stream().map(bo -> bo.getCode()+bo.getName()).forEach(System.out::println);

        boList.stream().distinct().map(bo -> "distinct:"+ bo.getCode()+bo.getName()).forEach(System.out::println);

//        String name = boList.stream().distinct().sorted(((o1, o2) -> {
//            return  - Integer.parseInt(o1.getCode()) - Integer.parseInt(o2.getCode());
//        })).map(BO::getName).collect(Collectors.joining(","));
//        System.out.println("appendDistinctString========="+name);

        String nameTwo = boList.stream().distinct().sorted().map(BO::getName).collect(Collectors.joining(","));
        System.out.println("appendDistinctString========="+nameTwo);
    }
}

@Data //lombok的data方法实现的属性有 @ToString, @EqualsAndHashCode, @Getter  @Setter @RequiredArgsConstructor
class BO implements Comparable {
    private String code;
    private String name;

    public BO create(String code, String name) {
        this.code = code;
        this.name = name;

        return this;
    }

    @Override
    public int compareTo(Object o) {
        return - Integer.parseInt(this.getCode()) - Integer.parseInt(((BO)o).getCode());
    }
}
