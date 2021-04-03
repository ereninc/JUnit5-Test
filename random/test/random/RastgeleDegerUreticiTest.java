/**
 * @author ASUS 02.04.2021 - 01:42
 *
 */
package random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RastgeleDegerUreticiTest {
	
	RastgeleDegerUretici rastgele;
	@BeforeAll
	public static void setupAll() {
		//awake methodu gibi ilk çalýþýyor
	}
	
	@BeforeEach
	public void setup() {
		//Her test birimi öncesinde burasý çalýþýyor.
		rastgele = new RastgeleDegerUretici();
	}
	
	//Elimize rastgele deðer geçmiþ mi kontrol ediliyor.
	@Test
	@DisplayName("Rastgele Deðer Üretildi Mi?")
	void RastgeleDegerUretildiMiTest() {
		long deger = rastgele.rastgeleUretici();
		assertNotNull(deger);
	}
	
	@AfterEach
	public void tearDown() {
		//Her test biriminden sonra burasý çalýþýyor.
	}
	
	@AfterAll
	public static void tearDownAll() {
		//Bütün testler bittiðinde burasý çalýþýyor.
	}
}