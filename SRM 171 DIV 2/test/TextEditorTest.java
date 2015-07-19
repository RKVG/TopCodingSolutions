import org.junit.Test;
import static org.junit.Assert.*;

public class TextEditorTest {
	
	@Test
	public void test0() {
		String[] text = new String[] {"The quick brown fox jumps over the lazy dog. "};
		int width = 7;
		assertArrayEquals(new String[] { "The",  "over",  "quick",  "the",  "brown",  "lazy",  "fox",  "dog.",  "jumps" }, new TextEditor().twoColumn(text, width));
	}
	
	@Test
	public void test1() {
		String[] text = new String[] {"Such a preposterous use of !punctuation! !!!","Who would write ... something like this ???"};
		int width = 17;
		assertArrayEquals(new String[] { "Such a",  "write ...",  "preposterous use",  "something like",  "of !punctuation!",  "this ???",  "!!! Who would" }, new TextEditor().twoColumn(text, width));
	}
	
	@Test
	public void test2() {
		String[] text = new String[] {" Forsaking monastic tradition,    twelve jovial",
"  friars gave up their vocation for a questionable",
"     existence on the flying trapeze.    "}
;
		int width = 25;
		assertArrayEquals(new String[] { "Forsaking monastic",  "vocation for a",  "tradition, twelve jovial",  "questionable existence on",  "friars gave up their",  "the flying trapeze." }, new TextEditor().twoColumn(text, width));
	}
	
	@Test
	public void test3() {
		String[] text = new String[] {" "," "," "," "," "," "};
		int width = 7;
		assertArrayEquals(new String[] { }, new TextEditor().twoColumn(text, width));
	}
	
	@Test
	public void test4() {
		String[] text = new String[] {" I WONDER by my troth, what thou,",
"and I Did, till we lovd? were we",
"not weand till then? But suckd on",
"countrey pleasures, childishly? Or",
"snorted we in the seaven sleepers",
"den? Twas so; But this, all",
"pleasures fancies bee. If ever any",
"beauty I did see, Which I desird,",
"and got, twas but a dreame of",
"thee. And now good morrow to our",
"waking soules, Which watch not one",
"another out of feare; For love, all",
"love of other sights controules,",
"And makes one little roome, an",
"every where. Let seadiscoverers to",
"new worlds have gone, Let Maps to",
"other, worlds on worlds have",
"showne, Let us possesse one world,",
"each hath one, and is one. My face",
"in thine eye, thine in mine",
"appeares, And true plaine hearts",
"doe in the faces rest, Where can we",
"finde two better hemispheares",
"Without sharpe North, without",
"declining West? What ever dyes, was",
"not mixt equally; If our two loves",
"be one, or, thou and I Love so",
"alike, that none doe slacken, none",
"can die.",
"John Donne"}
;
		int width = 45;
		assertArrayEquals(new String[] { "I WONDER by my troth, what thou, and I Did,",  "seadiscoverers to new worlds have gone, Let",  "till we lovd? were we not weand till then?",  "Maps to other, worlds on worlds have showne,",  "But suckd on countrey pleasures, childishly?",  "Let us possesse one world, each hath one, and",  "Or snorted we in the seaven sleepers den?",  "is one. My face in thine eye, thine in mine",  "Twas so; But this, all pleasures fancies bee.",  "appeares, And true plaine hearts doe in the",  "If ever any beauty I did see, Which I desird,",  "faces rest, Where can we finde two better",  "and got, twas but a dreame of thee. And now",  "hemispheares Without sharpe North, without",  "good morrow to our waking soules, Which watch",  "declining West? What ever dyes, was not mixt",  "not one another out of feare; For love, all",  "equally; If our two loves be one, or, thou",  "love of other sights controules, And makes",  "and I Love so alike, that none doe slacken,",  "one little roome, an every where. Let",  "none can die. John Donne" }, new TextEditor().twoColumn(text, width));
	}
}
