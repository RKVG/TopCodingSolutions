import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CheatCodeTest {

    @Test
    public void myTest() {
        String keyPresses = "AABAAACD";
        String[] codes = new String[]{"BAACC"};
        assertArrayEquals(new int[]{}, new CheatCode().matches(keyPresses, codes));
    }

    @Test
// @Test(timeout=2000)
    public void test0() {
        String keyPresses = "UUDDLRRLLRBASS";
        String[] codes = new String[]{"UUDDLRLRBA", "UUDUDLRLRABABSS", "DDUURLRLAB", "UUDDLRLRBASS", "UDLRRLLRBASS"};
        assertArrayEquals(new int[]{0, 3, 4}, new CheatCode().matches(keyPresses, codes));
    }

    @Test
    public void test1() {
        String keyPresses =           "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String[] codes = new String[]{"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"};
        assertArrayEquals(new int[]{0}, new CheatCode().matches(keyPresses, codes));
    }

    @Test(timeout = 2000)
    public void test2() {
        String keyPresses = "IDDQDDTSFHHALL";
        String[] codes = new String[]{"FHHALL", "FHSHH", "IDBEHOLDA", "IDBEHOLDI", "IDBEHOLDL",
                "IDBEHOLDR", "IDBEHOLDS", "IDBEHOLDV", "IDCHOPPERS", "IDCLEV",
                "IDCLIP", "IDDQD", "IDDT", "IDFA", "IDKFA", "IDMYPOS", "IDMUS"};
        assertArrayEquals(new int[]{0, 11}, new CheatCode().matches(keyPresses, codes));
    }

    @Test(timeout = 2000)
    public void test3() {
        String keyPresses = "AABBCCDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYY";
        String[] codes = new String[]{"ABCDE", "BCDEF", "CDEFG", "DEFGH", "EFGHI",
                "FGHIJ", "GHIJK", "HIJKL", "IJKLM", "JKLMN",
                "KLMNO", "LMNOP", "MNOPQ", "NOPQR", "OPQRS",
                "PQRST", "QRSTU", "RSTUV", "STUVW", "TUVWX",
                "UVWXY", "VWXYZ", "WXYZA", "XYZAB", "YZABC",
                "ZABCD"};
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, new CheatCode().matches(keyPresses, codes));
    }

    @Test(timeout = 2000)
    public void test4() {
        String keyPresses = "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ";
        String[] codes = new String[]{"LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSS", "LAKJDGSJKGLSDKHFKDFHDGHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDHHSDKKSJDHFHJGKDKLSLSLJKASSJ", "AKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKHHSJ", "LAKDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLJKAHS", "KJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDHHSDKKSJDHFHJGKDKLLSLJKAHS", "LAKGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGJKGLSDKHFKDFHDGHHDKKSJDHFHJGKDKLSLSLJKAHS", "LAKJDGJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHGHHSDKKSJDHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSL",
                "LAKJDGSJKGLSDKHFDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLJKAHSJ",
                "LAKJDGSJKGLSDHFKDFHDGHHSDKKSJDHFHJGKDKLSLSJKAHS", "KGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSL",
                "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDGHHSDKSJHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDGHHSDKSJHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJKDKLSLSLJKAHSJ",
                "LKJDGSJKGLSDKHFKDFHDGHHSDKKJDHFHJGKDKLSLSLJKAHS", "AKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDKLSLSLJKAHS",
                "LAJDGSJKGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFGKDKLSLSLJKAHSJ",
                "LKJDGSJKLSDKHFKDFHDGHHSDKSJDHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHHJGKDKLSLSLJKAHSJ",
                "AKJDGSJKGLSDKFKDFHDGHHSSJDHFJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJDHFJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSJHFHJGKDKLSLSLJKAHSJ",
                "LAKJDSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKSDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDSJKGLSDKHFKDFHDGHHSDKKSJDHFHJGKDLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSDKKJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDHHSDKKSJDHFHJGKDKLSLSLJKAHS", "LAKDGSJKGLSDKHFKDFHDGHHSDKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSDKHFKDFHDGHHSDKSJDHFHJGKDKLSLSLJKAS", "KJDGSJKGLSDKHFKDFHDGHSDKKSJDHFHJGKDKLSLSLJKAH",
                "LAKJDGSJKGLSDKHFKDFHDGHHDKKSJDHFHJGKDKLSLSLJKAHS", "LAKDGSJKGLSDKFHDGHHSDKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJKGLSKHFKDFHDHHSDKKSJDHFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHSKKSJDHFHJGKDKLSLSLJKAHSJ",
                "LAKJDGSJGLSDKHFKDFHDGHHSDKKSJDFHJGKDKLSLSLJKAHS", "LAKJDGSJKGLSDKHFKDFHDGHHDKKSJDHFHJGKDKLSLSLJKAHSJ"};
        assertArrayEquals(new int[]{1, 3, 7, 13, 17, 27, 43}, new CheatCode().matches(keyPresses, codes));
    }

    @Test
    public void test18() {
        String keyPresses = "ZXYXYYYZYZXXXZXZYXYXZZZXXZZYYYXZXYZYXYYYYYYYYZYXYX";
        String[] codes = new String[]{"YXXXX", "XXXZZ", "XZYXZ", "YYZXX", "YZZXY", "ZYZZX", "XXYYZ", "XZZXY", "ZXYZX",
                "XYXYY", "YXYYY", "ZXZZX", "XXYZZ", "XZYXZ", "ZXYYX", "YXYZY", "XXZYZ", "XZZYZ", "XYZZX", "ZZXXY",
                "YXYZY", "YYYZY", "XXZZX", "ZYXXZ", "ZXYYX", "XYYXY", "ZYZXX", "YZXYZ", "YYYYZ", "ZYXZZ", "XYZYX",
                "YYYZZ", "XYYZZ", "XYZXZ", "ZZZXX", "YXZZZ", "YXXZY", "YXYZX", "XXZZX", "ZZZYZ", "YXYXZ", "XZZZZ",
                "XYZYX", "YXYZX", "YXZXZ", "ZZXYY", "ZXZZY", "ZZZZY", "YXXYY", "YXZZX"};
        int[] results = new CheatCode().matches(keyPresses, codes);
        assertArrayEquals(new int[] {2, 9, 10, 13, 15, 20, 21, 26, 28, 30, 34, 35, 40, 42, 44, 46, 49}, results);
    }

    @Test
    public void test18a() {
        String keyPresses = "ZXYXYYYZYZXXXZXZYXYXZZZXXZZYYYXZXYZYXYYYYYYYYZYXYX";
        String[] codes = new String[]{"XZYXZ"};
        int[] results = new CheatCode().matches(keyPresses, codes);
        assertArrayEquals(new int[] {0}, results);
    }
}
