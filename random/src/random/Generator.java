/**
*
* @author Erencan ÝNANCI - erencan.inanci@ogr.sakarya.edu.tr
* @since 28.03.2021 - 23:56:27
* <p>
* KarakterUretici sýnýfýndan dönen rastgele karakterleri kullanarak anlamsýz cümleler, 2 karakter arasýnda karakter, verilen karakterler arasýndan karakter üretmeyi saðlayan metodlarýn barýndýrýldýðý sýnýf.
* </p>
*/

package random;

public class Generator {
	//Degiskenler
	char verilenIkiKarakter1, verilenIkiKarakter2;
	int adet;
	int length;
	char param1, param2, param3, param4, param5;
	int boslukSay;
	int rastgeleUretilenDeger;
	
	//region Random tek karakter
	public char karakterAl() {
		KarakterUretici karakterU = new KarakterUretici();
		rastgeleUretilenDeger = karakterU.rastgeleKarakterUret();
		return (char)rastgeleUretilenDeger;
	}

	public void tekKarakterYazdir() {
        //rastgele tek karakter yazdýran kod bloðu
        StringBuilder rastgeleKarakterYaz = new StringBuilder();
        char randomChar1 = karakterAl();
        rastgeleKarakterYaz.append(randomChar1);
        System.out.println("Rastgele karakter: "+rastgeleKarakterYaz.toString());
    }
	//endregion
    
    
    //region Verilen 2 karakter araliginda random
    public char verilenIkiKarakter(int karakter1, int karakter2) {
        while(true){
            rastgeleUretilenDeger = karakterAl();
            if((rastgeleUretilenDeger >= karakter1) && (rastgeleUretilenDeger <= karakter2))
                break;
        }
        return (char)rastgeleUretilenDeger; 
    }
   
    public void verilenKarakterParametreAyarla(char char1, char char2) {
        verilenIkiKarakter1 = char1;
        verilenIkiKarakter2 = char2;
    }
    
    public void verilenKarakterYazdir() {
    	//verilen 2 karakter arasýndan rastgele tek karakter yazdýran blok
        verilenKarakterParametreAyarla(verilenIkiKarakter1, verilenIkiKarakter2);
        StringBuilder rastgeleVerilenKrkArasiYaz = new StringBuilder();
        char randomCharBoundary = verilenIkiKarakter(verilenIkiKarakter1,verilenIkiKarakter2);
        rastgeleVerilenKrkArasiYaz.append(randomCharBoundary);
        System.out.println("Verilen iki karakter("+(verilenIkiKarakter1+", "+verilenIkiKarakter2)+"): "+rastgeleVerilenKrkArasiYaz.toString());
    } 
    //endregion
    
    //region Girilen sayi adetinde random karakter
    public String nTaneRandom(int sayi) throws InterruptedException{
        String s = "";
        for (int i = 1; i <= sayi; i++) {
            rastgeleUretilenDeger = karakterAl();
            s += (char) rastgeleUretilenDeger;
            Thread.sleep(0L);
        }
        return s;
    }
    
    public void nTaneRandomParametreAyarla(int sayi) throws InterruptedException {
        adet = sayi;
    }
    
    public void nTaneRandomYazdir() throws InterruptedException {
    	//n adet rastgele karakter yazdýran blok
        StringBuilder rastgeleNAdet = new StringBuilder();
        nTaneRandomParametreAyarla(adet);
        String nTaneKarakter = nTaneRandom(adet);
        rastgeleNAdet.append(nTaneKarakter);
        length = rastgeleNAdet.toString().length();
        System.out.println("Rastgele "+adet+" adet: "+rastgeleNAdet.toString());
    }    
    //endregion
    
    //region Verilen 5 karakter içinde random
    public char verilenKarakterlerden(int karakter1, int karakter2, int karakter3, int karakter4, int karakter5){
        while(true){
            rastgeleUretilenDeger = karakterAl();
            if((rastgeleUretilenDeger == karakter1) || (rastgeleUretilenDeger == karakter2) || (rastgeleUretilenDeger == karakter3) || (rastgeleUretilenDeger == karakter4) || (rastgeleUretilenDeger == karakter5))
                break;
        }
        return (char) rastgeleUretilenDeger; 
    }
    
    public void VerilenKarakterlerdenUretimParametreAyarla(char verilenParam1, char verilenParam2, char verilenParam3, char verilenParam4, char verilenParam5) {	
        param1 = verilenParam1;
        param2 = verilenParam2;
        param3 = verilenParam3;
        param4 = verilenParam4;
        param5 = verilenParam5;
    }
    
    public void verilenKarakterlerdenYazdir() {
    	//verilen karakterler arasýndan rastgele karakter yazdýran blok
        StringBuilder rastgeleBelirtilenKrkArasiYaz = new StringBuilder();
        VerilenKarakterlerdenUretimParametreAyarla(param1, param2, param3, param4, param5);
        char randomVerilen = verilenKarakterlerden(param1,param2,param3,param4,param5);
        rastgeleBelirtilenKrkArasiYaz.append(randomVerilen);
        System.out.println("Belirtilen Karakterler ("+param1+", "+param2+", "+param3+", "+param4+", "+param5+"): "+rastgeleBelirtilenKrkArasiYaz.toString());
    }
    //endregion
    
    //region Random cümle
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
        int boslukYerleri[] = new int[boslukAdedi]; //boþluklarýn geleceði indisleri dizide tuttum.
        
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
    
    public void cumleParametreAyarla(int sayi) {
    	boslukSay = sayi;
    }
    
    public void cumleYazdir() throws InterruptedException {
    	cumleParametreAyarla(boslukSay);
    	String rastgeleCumle = cumleOlustur(boslukSay);
        System.out.print("Rastgele Cumle : "+rastgeleCumle);
        System.out.print("\n");
    }
    //endregion
    
    public void ekranaYazdirTekSefer() throws InterruptedException{
        tekKarakterYazdir();
    	
    	verilenKarakterParametreAyarla('a', 'k');
    	verilenKarakterYazdir();
    	
    	nTaneRandomParametreAyarla(5);
    	nTaneRandomYazdir();
    	
    	VerilenKarakterlerdenUretimParametreAyarla('a', 'e', 'k', 'm', 'd');
    	verilenKarakterlerdenYazdir();
    	
    	cumleParametreAyarla(5);
    	cumleYazdir();
    }
    
    public void multipleEkranaYazdir() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            ekranaYazdirTekSefer();
            System.out.println("************");
        }
    }
}