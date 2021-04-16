/**
*
* @author Erencan ÝNANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 16.04.2021 - 21:06
* <p>
* RastgeleDegerUretici sýnýfýndaki metotlarýn birim test metotlarýnýn olduðu sýnýf.
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
	
	@Test
	@DisplayName("Rastgele Deðer Üretildi Mi?")
	void RastgeleDegerUretildiMiMockTest() {
		RastgeleDegerUretici mock = mock(RastgeleDegerUretici.class);
		when(mock.rastgeleUretici()).thenReturn((long)51051051);
		long deger = mock.rastgeleUretici();
		assertNotNull(deger);
	}
	
	@Test
	@DisplayName("Uretilen Deðer long Veritipinde Mi?")
	void RastgeleDegerVeritipiKontrol() {
		int a = 15;
		Object rnd = rastgele.rastgeleUretici();
		Object longVal = (long)a;
		assertEquals(rnd.getClass(), longVal.getClass());
	}
	
	//Üretilen deðer sýfýrdan büyük mü? Yani kullanýlabilir mi test ediliyor.
	@Test
	@DisplayName("Rastgele Deðer Sýfýrdan Büyük mü? (Kullanýlabilir mi?)")
	void RastgeleDegerSifirdanBuyukMuTest() {
		long deger = rastgele.rastgeleUretici();
		long uretilenDeger = deger>0? deger:0;
		assertEquals(uretilenDeger, deger);
	}
	
	@AfterEach
	public void tearDown() {
		//Her test biriminden sonra burasý çalýþýyor.
	}

}
