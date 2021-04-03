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

class Tests {

	@Nested
	@DisplayName("Rastgele Deger Uretici Test")
	class RastgeleDegerUreticiTest{
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
		
		//�retilen de�er s�f�rdan b�y�k m�? Yani kullan�labilir mi test ediliyor.
		@Test
		@DisplayName("Rastgele De�er S�f�rdan B�y�k m�?")
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

	@Nested
	@DisplayName("Karakter Uretici Test")
	class KarakterUreticiTest{
		KarakterUretici karakter;
		
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
	}
	
	@Nested
	@DisplayName("Tek Karakter Uretim Test")
	class TekKarakter{
		Generator gen;
		
		@BeforeEach
		public void setup() {
			//Her test birimi �ncesinde buras� �al���yor.
			gen = new Generator();
		}

		//Tek karakter test
		@Test
		@Tag("TekKarakterTest")
		@Order(1)
		@DisplayName("Karakter �retildi Mi")
		void KarakterTest() {
			char tek = gen.karakterAl();
			gen.tekKarakter();
			assertNotNull(tek);
		}

		@Test
		@Tag("TekKarakterTest")
		@Order(2)
		@DisplayName("Tek Karakter Mi �retildi?")
		void TekKarakterTest() {
			String a = "";
			char tek = gen.karakterAl();
			gen.tekKarakter();
			a += tek;
			assertEquals(1, a.length());
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra buras� �al���yor.
		}
	}
	
	@Nested
	@DisplayName("Verilen Aralik Icinde Karakter Uretim")
	class VerilenIkiKarakterArasi{
		Generator gen;
		
		@BeforeEach
		public void setup() {
			//Her test birimi �ncesinde buras� �al���yor.
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
			//Her test biriminden sonra buras� �al���yor.
		}
	}
	
	@Nested
	@DisplayName("Verilen Sayida Karakter Uretim")
	class nAdetRandom{
		Generator gen;
		@BeforeEach
		public void setup() {
			//Her test birimi �ncesinde buras� �al���yor.
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
			boolean esit = false;
			int length = gen.length;
			if(length == gen.adet) {
				esit = true;
			}
			assertSame(true, esit);
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra buras� �al���yor.
		}
	}

	@Nested
	@DisplayName("Verilen Karakterler Arasindan Uretim")
	class VerilenKarakterlerArasindanUretim{
		Generator gen;
		@BeforeEach
		public void setup() {
			//Her test birimi �ncesinde buras� �al���yor.
			gen = new Generator();
		}

		@Test
		@Tag("VerilenlerArasindanUretimTest")
		@Order(1)
		@DisplayName("?")
		void test() throws InterruptedException {
			
		}
		
		@AfterEach
		public void tearDown() {
			//Her test biriminden sonra buras� �al���yor.
		}
	}

}
