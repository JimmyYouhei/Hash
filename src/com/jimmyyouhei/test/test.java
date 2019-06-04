import com.jimmyyouhei.hash.StringHash;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    private final StringHash test1 = new StringHash("lorem ipsum dolor");
    private final StringHash test2 = new StringHash("foo");
    private final StringHash test3 = new StringHash("oof");

    @Test
    void foldingHashTest1(){
        assertEquals(1706390818 , test1.foldingHash());
    }

    @Test
    void additiveHashTest1(){
        assertEquals(1709 , test1.additiveHash());
    }

    @Test
    void foldingHashTest2(){
        assertEquals(7303014 , test2.foldingHash());
    }

    @Test
    void additiveHashTest2(){
        assertEquals(324 , test2.additiveHash());
    }

    @Test
    void foldingHashTest3(){
        assertEquals(6713199, test3.foldingHash());
    }

    @Test
    void additiveHashTest3(){
        assertEquals(324 , test3.additiveHash());
    }

}
