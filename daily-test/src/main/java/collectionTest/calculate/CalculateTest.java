package collectionTest.calculate;

import java.util.Date;

/**
 * @description 基础算法整理
 * @author liyunpeng
 * @date 2021/4/14 10:55
**/
public class CalculateTest {
    public static void main(String[] args) {

        // &、&&、|、||、^、<<、>>、~、>>>

        int a = 2 & 4;
        System.out.println(a);

        int b = ++ a +9;// ++ -- 运算符作用在运算表达式的时候,无论是前置还是后置都会生效
        System.out.println(b);

        System.out.println(5>>1);//乘2的n次
        System.out.println(5<<1);//除2的n次


    }
}
