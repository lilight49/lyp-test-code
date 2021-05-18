package collectionTest.string;

public class StringTest {
    public static void main(String[] args) {

        String a = "http://ram-garo-socia-prod.oss-cn-zhangjiakou.aliyuncs.com/mobile/2021/04/19/3b099056c68b49deb2f917e812fd0850/%E8%80%92%E9%98%B3%E5%B8%822021%E5%B9%B4%E5%BA%A6%E5%86%9C%E4%B8%9A%E7%94%9F%E4%BA%A7%E7%A4%BE%E4%BC%9A%E5%8C%96%E6%9C%8D%E5%8A%A1%E9%A1%B9%E7%9B%AE%E8%AF%95%E7%82%B9%E9%A1%B9%E7%9B%AE%E5%AE%9E%E6%96%BD%E6%96%B9%E6%A1%88%E6%B1%87%E7%BC%96%282020219%29.pdf?Expires=1618888303&OSSAccessKeyId=LTAIP816Jan0Nvjq&Signature=T9Zyyo%2FIoCSR2ncr0oe5EkbG64U%3D";

        int flatCount = a.lastIndexOf("?Expires");
        System.out.println(flatCount);

        String substring = a.substring(0,flatCount);

//        String substring = a.substring(0,a.length());
        System.out.println(substring);
    }
}
