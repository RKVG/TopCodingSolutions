import org.junit.Test;
import static org.junit.Assert.*;

public class GemsTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] board = new String[] {"ABC",
 "ABC",
 "BAD"};
		assertEquals(1, new Gems().numMoves(board));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] board = new String[] {"ABB",
 "BAA",
 "ABB"};
		assertEquals(3, new Gems().numMoves(board));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] board = new String[] {"ABA",
 "BAB",
 "ABA"};
		assertEquals(4, new Gems().numMoves(board));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] board = new String[] {"ABC",
 "DEF",
 "GHI"};
		assertEquals(0, new Gems().numMoves(board));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] board = new String[] {"SUMEEMEEPGPPG",
 "USPMIPSUSIISG",
 "UPSPGEGGPKEII",
 "KEMGISMKKIUIG",
 "MGSIIKMSISGKM",
 "SPGMSMIGMSMGM",
 "SSIIUKMPEPPUI",
 "UKUIUEMEEIGKE",
 "IPUPGUSEGSSUS",
 "EUPMKGGUKKEMI",
 "PEPSMUUEUSSIP",
 "SUMEEUSESUEKG",
 "EPSKUISGMSKGI",
 "IUGGUGGSIGUUP",
 "IUPIKKSGPPEEP",
 "KGEESGISPGGEM",
 "UEIUSSKPSSGPE",
 "KSUMKGEIMKPSE",
 "ESKEUEMMPPIGG",
 "UUIEUGGIGMEMK",
 "GPGMPPIUMEPMU",
 "IKIGGPIUEMIGS",
 "IPUSGUMKPKIPP",
 "UEEMUUEEGIPUS",
 "PPEKIKEMGGMSS",
 "EMKPMPUUMKEPU",
 "UKPGPKSUIEUPM",
 "PSUUMUKGIIPMS",
 "ESMGSKUEPGGEM",
 "SMEEIKGKGGPEG",
 "UEIEKPMESMEPP",
 "IPUIMGGMIPKMG",
 "ISSEKPKGKIUGU",
 "SSESKUGKISPUK"};
		assertEquals(83, new Gems().numMoves(board));
	}
}
