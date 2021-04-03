package random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
			gen.tekKarakter();
			assertNotNull(tek);
		}

		@Test
		@Tag("TekKarakterTest")
		@Order(2)
		@DisplayName("Tek Karakter Mi Üretildi?")
		void TekKarakterTest() {
			String a = "";
			char tek = gen.karakterAl();
			gen.tekKarakter();
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
			char uretilen = gen.verilenIkiKarakter('a', 'k');
			assertNotNull(uretilen);
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
		@DisplayName("Girilen Parametre Pozitif Mi?")
		void ParametrePozitifMiTest() throws InterruptedException {
			boolean pozitifMi = false;
			gen.nTaneRandomParametreAyarla(3);
			int deger = gen.adet;
			if(deger > 0) {
				pozitifMi = true;
			}
			assertSame(true, pozitifMi);
		}
		
		@Test
		@Tag("nAdetRandom")
		@Order(3)
		@DisplayName("Girilen Parametre Adetinde Mi Uretildi?")
		void ParametreMaxIntDegerindenKucukMuTest() throws InterruptedException {
			
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra burasý çalýþýyor.
		}
	}
}
