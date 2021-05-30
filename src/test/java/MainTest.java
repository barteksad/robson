import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void test_przyklad1() {
        Robson robson = new Robson();
        robson.fromJSON("/home/bartek/Desktop/UW/PO/robson/src/programy/przyklad1.json");
        assertEquals(robson.wykonaj(), 15.0);
    }

    @Test
    public void test_przyklad2() {
        Robson robson = new Robson();
        robson.fromJSON("/home/bartek/Desktop/UW/PO/robson/src/programy/przyklad2.json");
        assertEquals(robson.wykonaj(), 55.0);
    }

    @Test
    public void test_euclidian_algorythm() {
        Robson robson = new Robson();
        robson.fromJSON("/home/bartek/Desktop/UW/PO/robson/src/programy/euclidian_algorithm.json");
        assertEquals(robson.wykonaj(), 0);
    }
}
