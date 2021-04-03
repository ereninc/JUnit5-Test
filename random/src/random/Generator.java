/**
*
* @author Erencan �NANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 28.03.2021 - 23:56:27
* <p>
* KarakterUretici s�n�f�ndan d�nen rastgele karakterleri kullanarak anlams�z c�mleler, 2 karakter aras�nda karakter, verilen karakterler aras�ndan karakter �retmeyi sa�layan metodlar�n bar�nd�r�ld��� s�n�f.
* </p>
*/

package random;

public class Generator {
	char verilenIkiKarakter1, verilenIkiKarakter2;
	
	int rastgeleUretilenDeger;
	public char karakterAl() {
		KarakterUretici karakterU = new KarakterUretici();
		rastgeleUretilenDeger = karakterU.rastgeleKarakterUret();
		return (char)rastgeleUretilenDeger;
	}
	
    //girilen 2 karakter aras�ndaki karakterlerden rastgele harf �reten metot.
    public char verilenIkiKarakter(int karakter1, int karakter2) {
        while(true){
            rastgeleUretilenDeger = karakterAl();
            if((rastgeleUretilenDeger >= karakter1) && (rastgeleUretilenDeger <= karakter2))
                break;
        }
        return (char)rastgeleUretilenDeger; 
    }
    
    public void verilenKarakterParametreAyarla(char char1, char char2) {
    	//verilen 2 karakter aras�ndan rastgele tek karakter yazd�ran blok
        StringBuilder rastgeleVerilenKrkArasiYaz = new StringBuilder();
        verilenIkiKarakter1 = char1;
        verilenIkiKarakter2 = char2;
        char randomCharBoundary = verilenIkiKarakter(verilenIkiKarakter1,verilenIkiKarakter2);
        rastgeleVerilenKrkArasiYaz.append(randomCharBoundary);
        System.out.println("Verilen iki karakter("+(verilenIkiKarakter1+", "+verilenIkiKarakter2)+"): "+rastgeleVerilenKrkArasiYaz.toString());
    }
    
    
    //Girilen say� kadar rastgele karakter olu�turan metot.
    public String nTaneRandom(int sayi) throws InterruptedException{
        String s = "";
        for (int i = 1; i <= sayi; i++) {
            rastgeleUretilenDeger = karakterAl();
            s += (char) rastgeleUretilenDeger;
            Thread.sleep(0L);
        }
        return s;
    }
    
    //Random c�mle olu�turan metot.
    public String cumleOlustur(int boslukAdedi) throws InterruptedException{
    	KarakterUretici rast=new KarakterUretici();
        int karakterUzunluk;
        while(true) {
            karakterUzunluk = (int) ((rast.rastgeleDegeriAl())%97);
            if((karakterUzunluk>=15 && karakterUzunluk<=97))
                break;
        }
        
        String cumle = "";
        for (int i = 0; i < karakterUzunluk; i++) {
            cumle += karakterAl();
            try {
                Thread.sleep(0L);
            } catch (InterruptedException ex) {
            }
        }
        char cumleDonustur[] = null;
        cumleDonustur = cumle.toCharArray();
        int boslukYerleri[] = new int[boslukAdedi]; //bo�luklar�n gelece�i indisleri dizide tuttum.
        
        for (int i = 0; i < boslukAdedi; i++) {
            boslukYerleri[i] = (int) (System.nanoTime()%karakterUzunluk);
        }
        
        while(boslukAdedi != 0){
            for (int j = 0; j < cumle.length(); j++) {
                if (boslukAdedi != 0) {
                    cumleDonustur[boslukYerleri[j]] = ' ';
                    boslukAdedi--;
                }
            }
        }
        String cumleYeni = String.valueOf(cumleDonustur);
        return cumleYeni;
    }
    
    public char verilenKarakterlerden(int karakter1, int karakter2, int karakter3, int karakter4, int karakter5){
        while(true){
            rastgeleUretilenDeger = karakterAl();
            if((rastgeleUretilenDeger == karakter1) || (rastgeleUretilenDeger == karakter2) || (rastgeleUretilenDeger == karakter3) || (rastgeleUretilenDeger == karakter4) || (rastgeleUretilenDeger == karakter5))
                break;
        }
        return (char) rastgeleUretilenDeger; 
    }
    
    public void ekranaYazdirTekSefer() throws InterruptedException{
        /*//rastgele tek karakter yazd�ran kod blo�u
        StringBuilder rastgeleKarakterYaz = new StringBuilder();
        char randomChar1 = karakterAl();
        rastgeleKarakterYaz.append(randomChar1);
        System.out.println("Rastgele karakter: "+rastgeleKarakterYaz.toString());
        
        //verilen karakterler aras�ndan rastgele karakter yazd�ran blok
        StringBuilder rastgeleBelirtilenKrkArasiYaz = new StringBuilder();
        char paramx1 = 'g';
        char paramx2 = 'x';
        char paramx3 = 'u';
        char paramx4 = 'z';
        char paramx5 = 'a';
        char randomVerilen = verilenKarakterlerden(paramx1,paramx2,paramx3,paramx4,paramx5);
        rastgeleBelirtilenKrkArasiYaz.append(randomVerilen);
        System.out.println("Verilen karakter aras�ndan rastgele("+paramx1+", "+paramx2+", "+paramx3+", "+paramx4+", "+paramx5+"): "+rastgeleBelirtilenKrkArasiYaz.toString());
        
        //verilen 2 karakter aras�ndan rastgele tek karakter yazd�ran blok
        StringBuilder rastgeleVerilenKrkArasiYaz = new StringBuilder();
        char param1 = 'a';
        char param2 = 'k';
        char randomCharBoundary = verilenIkiKarakter(param1,param2);
        rastgeleVerilenKrkArasiYaz.append(randomCharBoundary);
        System.out.println("Verilen iki karakter("+(param1+", "+param2)+"): "+rastgeleVerilenKrkArasiYaz.toString());
        
        //n adet rastgele karakter yazd�ran blok
        StringBuilder rastgeleNAdet = new StringBuilder();
        int charSay = 3;
        String nTaneKarakter = nTaneRandom(charSay);
        rastgeleNAdet.append(nTaneKarakter);
        System.out.println("Rastgele "+charSay+" adet: "+rastgeleNAdet.toString());
        
        //c�mle yazd�ran blok
        String rastgeleCumle = cumleOlustur(5);
        System.out.print("Rastgele Cumle : "+rastgeleCumle);
        System.out.print("\n");*/
    	
    	//verilenKarakterParametreAyarla('a', 'k');
    }
    
    public void multipleEkranaYazdir() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            ekranaYazdirTekSefer();
            System.out.println("************");
        }
    }
}