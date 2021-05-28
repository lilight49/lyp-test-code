package collectionTest.reflect;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User().init();

        Field[] declaredFields = user.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.get(user) == null){
                continue;
            }

            System.out.println(declaredField.getName());
            System.out.println(declaredField.get(user).toString());
            System.out.println(declaredField.getType().getName());
        }
    }
}

@Data
class User{
    private String apiKey;
    private List<String> devices;
    private String startDate;
    private String endDate;
    private int length;
    private int page;
    private int age;

    /**
     * @methodName init
     * @description 数据初始化
     * @author liyunpeng
     * @date 2021/5/27 9:34
     * @return: void
     **/
    public User init(){
        this.apiKey = "d0b03894643a11eb972100163e2eae8a";
        this.length = 100;
        this.page = 1;

        List<String> list = new ArrayList<>();
//        list.add("123456");
//        list.add("123456");
        this.devices = list;

        return this;
    }
}
