import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManavSorusu {

     /* TASK :
         * Basit bir 5 ürünlü manav alisveris programi yaziniz.
         *
         * 1. Adim : urun listesinden urun sectir ve kac kilo oldugunu sor.
         * 2. Adim : Baska bir urun almak isteyip istemedigini sor.
         * 			 istemiyorsa toplam miktari goster, istiyorsa tekrar urun sectir.
         * 			 Bu islemi alisverisi bitirmek isteyene kadar tekrarla.
         * 3. Adim : Musteri her urun sectiginde, aldigi urunun fiyatini toplam fiyata ekle.
         * 4. Adim : Alisveris bitince toplam odemesi gereken tutari goster.

        Ipucu:
        Class icinde 3 method olacak
         * main() isimli bir method
         * musteriSecimi() isimli bir method
         * kasa() isimli bir method
         *
      */



    public static void main(String[] args) {

        List<String> urunListesi = urunleriOlustur();
        urunFiyatlari();
        musteriSecimi(urunListesi);
    }

    public static void musteriSecimi(List<String> urunListesi) {
        double toplam = 0;
        do {
            Scanner input = new Scanner(System.in);

            System.out.println("Lutfen almak istediginiz urunun adini yaziniz veya cikmak istiyorsaniz 'bitir' yaziniz:");
            String urun = input.next().toLowerCase();

            if(urunListesi.contains(urun)) {
                System.out.println("Lutfen almak istediginiz urunun kg'sini yaziniz: ");
                double kg = input.nextDouble();
                toplam = kasa(urun, kg, toplam);
            }else {
                if(urun.equals("bitir")) {
                    System.out.println("Alisveris Toplam Tutari: " + toplam + " TL");
                    break;
                }else {
                    System.out.println("Girdiginiz urun stoklarda bulunmamaktadir.");
                }
            }

        }while (true);
    }

    public static double kasa(String urun, double kg, double toplam) {
        switch (urun) {
            case "domates":
                toplam += 3.15 * kg;
                break;
            case "biber":
                toplam += 5.00 * kg;
                break;
            case "sarimsak":
                toplam += 7.89 * kg;
                break;
            case "sogan":
                toplam += 2.25 * kg;
                break;
            case "muz":
                toplam += 15.99 * kg;
                break;
        }
        return toplam;
    }

    public static void urunFiyatlari() {
        System.out.println("Domates  ===> 3.15 TL");
        System.out.println("Biber    ===> 5.00 TL");
        System.out.println("Sarimsak ===> 7.89 TL");
        System.out.println("Sogan    ===> 2.25 TL");
        System.out.println("Muz      ===> 15.99 TL");
    }

    public static List<String> urunleriOlustur() {
        List<String> urunListesi = new ArrayList<>();
        urunListesi.add("domates");
        urunListesi.add("biber");
        urunListesi.add("sogan");
        urunListesi.add("sarimsak");
        urunListesi.add("muz");

        return urunListesi;
    }

}
