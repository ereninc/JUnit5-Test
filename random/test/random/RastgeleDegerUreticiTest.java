/**
 * 
 */
package random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ASUS 02.04.2021 - 01:42
 *
 */
class RastgeleDegerUreticiTest {
	
	@Test
	void test() {
		RastgeleDegerUretici rastgele = new RastgeleDegerUretici();
		long deger = rastgele.rastgeleUretici();
		long uretilenDeger = deger>0? deger:0;
		assertEquals(uretilenDeger, deger);
	}

}
