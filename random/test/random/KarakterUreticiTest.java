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
		//awake methodu gibi ilk �al���yor
	}
	
	@BeforeEach
	public void setup() {
		//Her test birimi �ncesinde buras� �al���yor.
		karakter = new KarakterUretici();
	}
	
	//Bu classta kullan�lacak de�er elimize ge�mi� mi kontrol.
	@Test
	@DisplayName("Rastgele De�er Bu Class'a Aktar�ld� m�?")
	void KarakterUlastiMiTest() {
		long deger = karakter.rastgeleDegeriAl();
		assertNotNull(deger);
	}
	
	//Class'a de�er ula�t�ysa bunu kullanarak karakter �retilmi� mi kontrol.
	@Test
	@DisplayName("Rastgele De�erden Char �retildi Mi?")
	void KarakterUretildiMiTest() {
		char k = karakter.rastgeleKarakterUret();
		assertNotNull(k);
	}
	
	@AfterEach
	public void tearDown() {
		//Her test biriminden sonra buras� �al���yor.
	}
	
	@AfterAll
	public static void tearDownAll() {
		//B�t�n testler bitti�inde buras� �al���yor.
	}

}
