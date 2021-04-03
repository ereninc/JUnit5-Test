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
	@DisplayName("TekKarakter")
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
	@DisplayName("VerilenAralik")
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
		@DisplayName("Parametreler Char Mý?")
		void ParametreTest() {
			gen.verilenKarakterParametreAyarla('c', 'j');
			int charToInt1 = (int)gen.verilenIkiKarakter1;
			int charToInt2 = (int)gen.verilenIkiKarakter2;
			if(charToInt1 < charToInt2) {
				System.out.println(charToInt1 + " ve " + charToInt2);
				System.out.println("Kucuk");
			}
		}

		@Test
		@Tag("VerilenAraliktaTekKarakter")
		@Order(2)
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
	
	
	
	

}
