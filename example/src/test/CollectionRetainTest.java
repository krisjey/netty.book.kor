import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectionRetainTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        Set<String> retainTest = new HashSet<String>();
        retainTest.add("Test1");
        retainTest.add("Test2");
        retainTest.add("Test3");
        retainTest.add("Test4");
        retainTest.add("Test5");
        
        Set<String> retain = new HashSet<String>();
        retain.add("Test3");
        retainTest.retainAll(retain);
        
        System.err.println(retain);
    }
}
