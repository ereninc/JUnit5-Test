/**
*
* @author Erencan ÝNANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 16.04.2021 - 21:06
* <p>
* Generator sýnýfýndaki metotlarýn birim test metotlarýnýn olduðu sýnýf.
* </p>
*/

package random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.github.javafaker.Faker;

class GeneratorTest {
	@Nested
	@DisplayName("Tek Karakter Uretim Test")
	class TekKarakter{
		Generator gen;
		
		@BeforeEach
		public void setup() {
			//Her test birimi öncesinde burasý çalýþýyor.
			gen = new Generator();
		}

		//Tek karakter test
		@Test
		@Tag("TekKarakterTest")
		@Order(1)
		@DisplayName("Karakter Üretildi Mi")
		void KarakterTest() {
			char tek = gen.karakterAl();
			assertNotNull(tek);
		}
		
		@Test
		@Tag("TekKarakterTest")
		@Order(2)
		@DisplayName("Uretilen Veritipi Karakter Mi?")
		void KarakterTipTest() {
			Object karakterObject = gen.karakterAl();
			Object charObj = 'a';
			assertEquals(karakterObject.getClass(), charObj.getClass());
		}
		
		@Test
		@Tag("TekKarakterTest")
		@Order(3)
		@DisplayName("Uretilen Veritipi Karakter Mi Mock?")
		void KarakterTipMockTest() {
			Generator mock = mock(Generator.class);
			when(mock.karakterAl()).thenReturn('Z');
			Object karakterObject = mock.karakterAl();
			Object charObj = 'a';
			assertEquals(karakterObject.getClass(), charObj.getClass());
		}

		@Test
		@Tag("TekKarakterTest")
		@Order(4)
		@DisplayName("Tek Karakter Mi Üretildi?")
		void TekKarakterTest() {
			String a = "";
			char tek = gen.karakterAl();
			a += tek;
			assertEquals(1, a.length());
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra burasý çalýþýyor.
		}
	}
	
	@Nested
	@DisplayName("Verilen Aralik Icinde Karakter Uretim")
	class VerilenIkiKarakterArasi{
		Generator gen;
		
		@BeforeEach
		public void setup() {
			//Her test birimi öncesinde burasý çalýþýyor.
			gen = new Generator();
		}

		@Test
		@Tag("VerilenAraliktaTekKarakter")
		@Order(1)
		@DisplayName("Karakter Uretiliyor Mu?")
		void UretimVarMiTest() {
			char uretilen = gen.verilenIkiKarakter('a', 'c');
			assertNotNull(uretilen);
		}
		
		@Test
		@Tag("VerilenAraliktaTekKarakter")
		@Order(1)
		@DisplayName("Karakter Uretiliyor Mu Mock?")
		void UretimVarMiMockTest() {
			Generator mock = mock(Generator.class);
			when(mock.verilenIkiKarakter('a','c')).thenReturn('b');
			char uretilen = mock.verilenIkiKarakter('a', 'c');
			assertEquals(uretilen, 'b');
		}
		
		@Test
		@Tag("VerilenAraliktaTekKarakter")
		@Order(2)
		@DisplayName("Uretilen Char Mi?")
		void UretilenCharTest() {
			gen.verilenKarakterParametreAyarla('e', 'm');
			Object charObj = 'a';
			Object uretilenObj = gen.verilenIkiKarakter('a', 'k');
			assertSame(charObj.getClass(), uretilenObj.getClass());
		}
		
		@Test
		@Tag("VerilenAraliktaTekKarakter")
		@Order(3)
		@DisplayName("Parametreler Char Mi?")
		void ParametreCharTest() {
			boolean esit = false;
			Object charObj = 'a';
			Object parametreObj1 = gen.verilenIkiKarakter1;
			Object parametreObj2 = gen.verilenIkiKarakter2;
			
			if((charObj.getClass() == parametreObj1.getClass()) && (charObj.getClass() == parametreObj2.getClass())) {
				esit = true;
			}
			assertSame(true, esit);
		}

		@Test
		@Tag("VerilenAraliktaTekKarakter")
		@Order(4)
		@DisplayName("Parametreler Alfabetik Sirali Mi?")
		void ParametreSiraliMiTest() {
			boolean kucukmu = false;
			gen.verilenKarakterParametreAyarla('a', 'k');
			int charToInt1 = (int)gen.verilenIkiKarakter1;
			int charToInt2 = (int)gen.verilenIkiKarakter2;
			if(charToInt1 < charToInt2) {
				kucukmu = true;
			}
			assertSame(true, kucukmu);
		}
		
		@ParameterizedTest
		@DisplayName("ParametreliTestBasariliMi?")
		@Tag("VerilenAraliktaTekKarakter")
		@Order(5)
		@CsvSource({"'a','b'", "'f','g'"})
		void ParametreliTest(char ch1, char ch2) {
			boolean basarili = false;
			char paramTestUretilen = gen.verilenIkiKarakter(ch1, ch2);
			if(paramTestUretilen == ch1 || paramTestUretilen == ch2) {
				basarili = true;
			}
			assertEquals(true, basarili);
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra burasý çalýþýyor.
		}
	}
	
	@Nested
	@DisplayName("Verilen Sayida Karakter Uretim")
	class nAdetRandom{
		Generator gen;
		@BeforeEach
		public void setup() {
			//Her test birimi öncesinde burasý çalýþýyor.
			gen = new Generator();
		}

		@Test
		@Tag("nAdetRandom")
		@Order(1)
		@DisplayName("Girilen Parametre integer Mi?")
		void ParametreIntMiTest() throws InterruptedException {
			gen.nTaneRandomParametreAyarla(5);
			Object intDeger = 15;
			Object gelenDeger = gen.adet;
			assertSame(intDeger.getClass(), gelenDeger.getClass());
		}
		
		@Test
		@Tag("nAdetRandom")
		@Order(2)
		@DisplayName("Faker - Girilen Parametre Pozitif Mi?")
		void ParametrePozitifMiTest() throws InterruptedException {
			boolean pozitifMi = false;
			Faker faker = new Faker();
			int value = faker.number().numberBetween(0, 999);
			gen.nTaneRandomParametreAyarla(value);
			int deger = gen.adet;
			if(deger > 0) {
				pozitifMi = true;
			}
			assertSame(true, pozitifMi);
		}
		
		@Test
		@Tag("nAdetRandom")
		@Order(3)
		@DisplayName("Uretildi Mi?")
		void UretimTest() throws InterruptedException {
			assertEquals(0, gen.adet);
		}
		
		@Test
		@Tag("nAdetRandom")
		@Order(4)
		@DisplayName("Girilen Parametre Adetinde Mi Uretildi?")
		void ParametreMaxIntDegerindenKucukMuTest() throws InterruptedException {
			boolean esit = false;
			int length = gen.length;
			if(length == gen.adet) {
				esit = true;
			}
			assertSame(true, esit);
		}
		
		@ParameterizedTest
		@DisplayName("ParametreliTestBasariliMi?")
		@Tag("nAdetRandom")
		@Order(5)
		@CsvSource({"5", "1", "15", "20", "8", "-1", "0"})
		void ParametreliTest(int sayi) {
			boolean esit = false;
			sayi = gen.length;
			if(sayi == gen.adet) {
				esit = true;
			}
			assertSame(true, esit);
		}
		
		@Test
		@Tag("nAdetRandom")
		@Order(6)
		@DisplayName("Faker - Girilen Parametre integer Mi?")
		void FakerParametreIntMiTest() throws InterruptedException {
			Faker faker = new Faker();
			int param = faker.number().numberBetween(1, 15);
			gen.nTaneRandomParametreAyarla(param);
			Object intDeger = param;
			Object gelenDeger = gen.adet;
			assertSame(intDeger.getClass(), gelenDeger.getClass());
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra burasý çalýþýyor.
		}
	}

	@Nested
	@DisplayName("Verilen Karakterler Arasindan Uretim")
	class VerilenKarakterlerArasindanUretim{
		Generator gen;
		@BeforeEach
		public void setup() {
			//Her test birimi öncesinde burasý çalýþýyor.
			gen = new Generator();
		}

		@Test
		@Tag("VerilenlerArasindanUretimTest")
		@Order(1)
		@DisplayName("Girilen Parametreler Char Mi?")
		void ParametreTipTest() throws InterruptedException {
			Object o1 = gen.param1;
			Object o2 = gen.param2;
			Object o3 = gen.param3;
			Object o4 = gen.param4;
			Object o5 = gen.param5;
			Object charObj = 'a';
			boolean hepsiChar = false;
			if(charObj.getClass() == o1.getClass() && charObj.getClass() == o2.getClass() && charObj.getClass() == o3.getClass() &&
					charObj.getClass() == o4.getClass() && charObj.getClass() == o5.getClass()) {
				hepsiChar = true;
			}
			assertSame(true, hepsiChar);
		}
		
		@Test
		@Tag("VerilenlerArasindanUretimTest")
		@Order(2)
		@DisplayName("Uretilmis Mi?")
		void UretilmisMiTest() {
			char karakter = gen.verilenKarakterlerden('a', 'k', 'b', 'c', 'z');
			assertNotNull(karakter);
		}
		
		@Test
		@Tag("VerilenlerArasindanUretimTest")
		@Order(3)
		@DisplayName("Uretilen Veri Karakter Mi?")
		void KarakterUretilmisMiTest() {
			Object obj = gen.verilenKarakterlerden('a', 'k', 'b', 'c', 'z');
			Object charObj = 'a';
			assertEquals(obj.getClass(), charObj.getClass());
		}
		
		@ParameterizedTest
		@DisplayName("ParametreliTestBasariliMi?")
		@Order(4)
		@CsvSource({"'a','b','c','d','e'", "'f','g','b','d','n'", "'x','n','o','y','i'", "'z','q','r','t','f'"})
		void ParametreliTest(char ch1, char ch2, char ch3, char ch4, char ch5) {
			boolean basarili = false;
			char paramTestUretilen = gen.verilenKarakterlerden(ch1, ch2, ch3, ch4, ch5);
			if(paramTestUretilen == ch1 || paramTestUretilen == ch2 ||paramTestUretilen == ch3 ||paramTestUretilen == ch4 ||paramTestUretilen == ch5) {
				basarili = true;
			}
			assertEquals(true, basarili);
		}
		
		@Test
		@Tag("VerilenlerArasindanUretimTest")
		@Order(5)
		@DisplayName("Uretilmis Mi?")
		void FakerUretilmisMiTest() {
			Faker faker = new Faker();
			char param1 = faker.lorem().character(false);
			char param2 = faker.lorem().character(false);
			char param3 = faker.lorem().character(false);
			char param4 = faker.lorem().character(false);
			char param5 = faker.lorem().character(false);
			char karakter = gen.verilenKarakterlerden(param1, param2, param3, param4, param5);
			assertNotNull(karakter);
		}
		
		@Test
		@Tag("VerilenlerArasindanUretimTest")
		@Order(5)
		@DisplayName("Uretilmis Mi?")
		void FakerUretilmisMiMockTest() {
			Generator mock = mock(Generator.class);
			when(mock.verilenKarakterlerden('a', 'z', 'c', 'k', 'q')).thenReturn('q');
			char karakter = mock.verilenKarakterlerden('a', 'z', 'c', 'k', 'q');
			assertEquals(karakter, 'q');
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra burasý çalýþýyor.
		}
	}

	@Nested
	@DisplayName("Rastgele Cumle Uretici Test")
	class CumleOlusturucuTest{
		Generator gen;
		@BeforeEach
		public void setup() {
			//Her test birimi öncesinde burasý çalýþýyor.
			gen = new Generator();
		}
		
		
		@Test
		@DisplayName("Kelime Adedi Parametresi Integer Mi?")
		void ParametreIntMiTest() throws InterruptedException {
			gen.cumleOlustur(5);
			Object intDeger = 15;
			Object gelenDeger = gen.adet;
			assertSame(intDeger.getClass(), gelenDeger.getClass());
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra burasý çalýþýyor.
		}
	}
}