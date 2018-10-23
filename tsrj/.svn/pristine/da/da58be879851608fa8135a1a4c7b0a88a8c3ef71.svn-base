import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ClassLoaderTest {
    private static final Logger LOG = LoggerFactory.getLogger(ClassLoaderTest.class);

    private static Map map = new HashMap();
    static{
        map.put("a", "2");
    }

    public static void main(String[] args){
//        System.out.println("this is main method!");
//        String b = (String)map.get("a");
//        Integer a = Integer.parseInt((String) map.get("a"));
        try{
            Class.forName("");
        }catch(ClassNotFoundException e){
            LOG.error("类加载异常{}", e);
        }

    }

    @Test
    public void testOne(){
        //System.out.println(this.getClass().getClassLoader().getResource("").toString());
        try{
            //第一种
            // Class.forName("");
            //第二种
            this.getClass().getClassLoader().loadClass("class");
            //第三种  -----??
            // this.getClass().getClassLoader().
        }catch(ClassNotFoundException e){
            LOG.error("类加载异常{}", e);
        }
    }


    public static final String HELLO_WORD = "hello world";
    private static ClassLoaderTest classLoaderTest = new ClassLoaderTest();
    private static Map<Integer,Boolean> test =
            new HashMap<Integer, Boolean>();

    private ClassLoaderTest()
    {
        test.put(1, true);
    }

    public ClassLoaderTest(String a){

    }

    public static ClassLoaderTest getInstance()
    {
        return classLoaderTest;
    }
}
