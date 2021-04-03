/**
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

/**
 * @author ASUS 03.04.2021 - 16:17
 *
 */
class KarakterUreticiTest {

	KarakterUretici karakter;
	@BeforeAll
	public static void setupAll() {
		//awake methodu gibi ilk çalýþýyor
	}
	
	@BeforeEach
	public void setup() {
		//Her test birimi öncesinde burasý çalýþýyor.
		karakter = new KarakterUretici();
	}
	
	//Bu classta kullanýlacak deðer elimize geçmiþ mi kontrol.
	@Test
	@DisplayName("Rastgele Deðer Bu Class'a Aktarýldý mý?")
	void KarakterUlastiMiTest() {
		long deger = karakter.rastgeleDegeriAl();
		assertNotNull(deger);
	}
	
	//Class'a deðer ulaþtýysa bunu kullanarak karakter üretilmiþ mi kontrol.
	@Test
	@DisplayName("Rastgele Deðerden Char Üretildi Mi?")
	void KarakterUretildiMiTest() {
		char k = karakter.rastgeleKarakterUret();
		assertNotNull(k);
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
