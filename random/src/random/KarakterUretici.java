/**
*
* @author Erencan �NANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 28.03.2021 - 22:53:33
* <p>
* RastgeleDegerUretici s�n�f�ndan d�nen rastgele de�eri kullanarak sadece "karakter" �retmeyi sa�layan metodu bar�nd�ran s�n�f.
* </p>
*/

package random;

public class KarakterUretici {
	long rastgeleUretilenDeger;
	public long rastgeleDegeriAl() {
		RastgeleDegerUretici randU = new RastgeleDegerUretici();
		rastgeleUretilenDeger = randU.rastgeleUretici();
		return rastgeleUretilenDeger;
	}
	
    //karakter �retilmesini sa�layan metot.
    public char rastgeleKarakterUret() {
        char karakter;
        while(true) {
            rastgeleUretilenDeger = (int) ((rastgeleDegeriAl())%123);
            // ascii table'a g�re �retim
            if((rastgeleUretilenDeger>=65 && rastgeleUretilenDeger<=90) || (rastgeleUretilenDeger>=97 && rastgeleUretilenDeger<=122))
                break;
        }
        karakter=(char) rastgeleUretilenDeger;
        return karakter;
    }
}