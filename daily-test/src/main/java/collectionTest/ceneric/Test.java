package collectionTest.ceneric;


import lombok.Data;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static <T> Object getTest(TestInterface<T> tTestInterface){
        List list = new ArrayList<>();
        list.add("tTestInterface");
        list.add(17);

        User user = new User().createUser("1","li");
        list.add(user);


        return tTestInterface.getTest((List<T>) list);
    }

    public static void main(String[] args) {
        ((List) getTest(new TestClass())).forEach(test->{
            Object test1 = test;

            if (test instanceof User) {
                User user = (User) test;
                System.out.println(user.toString());
            }
        });
    }

}

@Data
class User{
    private String id;
    private String name;

    public User createUser(String id, String name) {
        this.id = id;
        this.name = name;

        return this;
    }
}

