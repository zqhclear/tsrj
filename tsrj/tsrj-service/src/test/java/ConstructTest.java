public class ConstructTest {
    int i;

    public ConstructTest() {
        System.out.println(i);
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        ConstructTest t = new ConstructTest();
    }
}
