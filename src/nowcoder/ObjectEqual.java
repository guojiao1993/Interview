package nowcoder;

/**
 * Object中的equals方法直接比较对象的==，即是否指向内存中同一个位置
 * @date 2018-07-19
 */
public class ObjectEqual {
    String s = "abc";

    public static void main(String[] args) {
        System.out.println(new ObjectEqual());
        System.out.println(new ObjectEqual().equals(new ObjectEqual()));
        System.out.println(new ObjectEqual().s.equals(new ObjectEqual().s));
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);
        return toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return s;
    }
}
