/**
*
* @author Erencan �NANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 28.03.2021 - 22:41:12
* <p>
* Sistem saatini kullanarak rastgele de�er d�nd�r�ren metodu bar�nd�ran s�n�f.
* </p>
*/

package random;

public class RastgeleDegerUretici {
    public long rastgeleUretici() {
        long randValue = System.nanoTime();
        return randValue;
    }
}