/**
*
* @author Erencan ÝNANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 28.03.2021 - 22:53:33
* <p>
* RastgeleDegerUretici sýnýfýndan dönen rastgele deðeri kullanarak sadece "karakter" üretmeyi saðlayan metodu barýndýran sýnýf.
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
	
    //karakter üretilmesini saðlayan metot.
    public char rastgeleKarakterUret() {
        char karakter;
        while(true) {
            rastgeleUretilenDeger = (int) ((rastgeleDegeriAl())%123);
            // ascii table'a göre üretim
            if((rastgeleUretilenDeger>=65 && rastgeleUretilenDeger<=90) || (rastgeleUretilenDeger>=97 && rastgeleUretilenDeger<=122))
                break;
        }
        karakter=(char) rastgeleUretilenDeger;
        return karakter;
    }
}