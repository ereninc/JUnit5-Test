/**
*
* @author Erencan ÝNANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 16.04.2021 - 21:08
* <p>
* KarakterUretici sýnýfýndaki metotlarýn birim test metotlarýnýn olduðu sýnýf.
* </p>
*/

package random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.github.javafaker.Faker;

@DisplayName("Karakter Uretici Test")
class KarakterUreticiTest {

	@Mock
	KarakterUretici karakter;
	
	@InjectMocks
	KarakterUretici kar;
	
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
	
	@Test
	@DisplayName("Faker-Rastgele Deðer ile Uretim Yapiliyor Mu?")
	void FakerKarakterUlastiMiTest() {
		Faker faker = new Faker();
		long deger = faker.number().randomNumber();
		int val;
		char karakter;
        while(true) {
        	val = (int) (deger%123);
            if((val>=65 && val<=90) || (val>=97 && val<=122))
                break;
            else
            	break;
        }
        karakter=(char) val;
		assertNotNull(karakter);
	}
	
	//Class'a deðer ulaþtýysa bunu kullanarak karakter üretilmiþ mi kontrol.
	@Test
	@DisplayName("Rastgele Deðerden Char Üretildi Mi Mock?")
	void KarakterUretildiMiMockTest() {
		KarakterUretici mock = mock(KarakterUretici.class);
		when(mock.rastgeleKarakterUret()).thenReturn('a');
		char k = mock.rastgeleKarakterUret();
		assertNotNull(k);
	}
	
	@Test
	@DisplayName("Rastgele Deðerden Char Üretildi Mi?")
	void KarakterUretildiMiTest() {
		char k = karakter.rastgeleKarakterUret();
		assertNotNull(k);
	}
	
	@Test
	@DisplayName("Uretilen Veritipi Karakter Mi?")
	void KarakterTipTest() {
		Object karakterObject = karakter.rastgeleKarakterUret();
		Object charObj = 'a';
		assertEquals(karakterObject.getClass(), charObj.getClass());
	}
	
	@Test
	@DisplayName("Uretilen Veritipi Karakter Mi Mock?")
	void KarakterTipMockTest() {
		KarakterUretici mock = mock(KarakterUretici.class);
		when(mock.rastgeleKarakterUret()).thenReturn('X');
		Object karakterObject = mock.rastgeleKarakterUret();
		Object charObj = 'a';
		assertEquals(karakterObject.getClass(), charObj.getClass());
	}
	
	@RepeatedTest(6)
	@DisplayName("Tekrar Testinde Sadece Karakter Mi Uretildi?")
	void TekrarTesti() {
		Object karakterObject = karakter.rastgeleKarakterUret();
		Object charObj = 'a';
		assertEquals(karakterObject.getClass(), charObj.getClass());
	}

	@AfterEach
	public void tearDown() {
		//Her test biriminden sonra burasý çalýþýyor.
	}
}
