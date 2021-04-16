/**
*
* @author Erencan �NANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 16.04.2021 - 21:06
* <p>
* RastgeleDegerUretici s�n�f�ndaki metotlar�n birim test metotlar�n�n oldu�u s�n�f.
* </p>
*/

package random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Rastgele Deger Uretici Test")
class RastgeleDegerUreticiTest {

	RastgeleDegerUretici rastgele;
	
	@BeforeEach
	public void setup() {
		//Her test birimi �ncesinde buras� �al���yor.
		rastgele = new RastgeleDegerUretici();
	}
	
	//Elimize rastgele de�er ge�mi� mi kontrol ediliyor.
	@Test
	@DisplayName("Rastgele De�er �retildi Mi?")
	void RastgeleDegerUretildiMiTest() {
		long deger = rastgele.rastgeleUretici();
		assertNotNull(deger);
	}
	
	@Test
	@DisplayName("Rastgele De�er �retildi Mi?")
	void RastgeleDegerUretildiMiMockTest() {
		RastgeleDegerUretici mock = mock(RastgeleDegerUretici.class);
		when(mock.rastgeleUretici()).thenReturn((long)51051051);
		long deger = mock.rastgeleUretici();
		assertNotNull(deger);
	}
	
	@Test
	@DisplayName("Uretilen De�er long Veritipinde Mi?")
	void RastgeleDegerVeritipiKontrol() {
		int a = 15;
		Object rnd = rastgele.rastgeleUretici();
		Object longVal = (long)a;
		assertEquals(rnd.getClass(), longVal.getClass());
	}
	
	//�retilen de�er s�f�rdan b�y�k m�? Yani kullan�labilir mi test ediliyor.
	@Test
	@DisplayName("Rastgele De�er S�f�rdan B�y�k m�? (Kullan�labilir mi?)")
	void RastgeleDegerSifirdanBuyukMuTest() {
		long deger = rastgele.rastgeleUretici();
		long uretilenDeger = deger>0? deger:0;
		assertEquals(uretilenDeger, deger);
	}
	
	@AfterEach
	public void tearDown() {
		//Her test biriminden sonra buras� �al���yor.
	}

}
