import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongWordsDiv2Test {

    @Test
    public void test0() {
        String word = "AAA";
        assertEquals("Dislikes", new LongWordsDiv2().find(word));
    }

    @Test
    public void test1() {
        String word = "ABCBA";
        assertEquals("Likes", new LongWordsDiv2().find(word));
    }

    @Test
    public void test2() {
        String word = "ABCBAC";
        assertEquals("Dislikes", new LongWordsDiv2().find(word));
    }

    @Test
    public void test3() {
        String word = "TOPCODER";
        assertEquals("Likes", new LongWordsDiv2().find(word));
    }

    @Test
    public void test4() {
        String word = "VAMOSGIMNASIA";
        assertEquals("Dislikes", new LongWordsDiv2().find(word));
    }

    @Test
    public void test5() {
        String word = "SINGLEROUNDMATCH";
        assertEquals("Likes", new LongWordsDiv2().find(word));
    }

    @Test
    public void test6() {
        String word = "DALELOBO";
        assertEquals("Likes", new LongWordsDiv2().find(word));
    }
}
