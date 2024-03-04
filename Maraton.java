package com.company;

import java.util.HashMap;
import java.util.Map;

public class Maraton {
    public static void main(String[] args) {
        Ogrenci[] ogrenciler = {
                new Ogrenci("Kadir", 341),
                new Ogrenci("Gökhan", 273),
                new Ogrenci("Hakan", 278),
                new Ogrenci("Suzan", 329),
                new Ogrenci("Pınar", 445),
                new Ogrenci("Mehmet", 402),
                new Ogrenci("Ali", 388),
                new Ogrenci("Emel", 270),
                new Ogrenci("Fırat", 243),
                new Ogrenci("James", 334),
                new Ogrenci("Jale", 412),
                new Ogrenci("Ersin", 393),
                new Ogrenci("Deniz", 299),
                new Ogrenci("Gözde", 343),
                new Ogrenci("Anıl", 317),
                new Ogrenci("Burak", 265),
        };

        Ogrenci enIyi = enIyiKosucuyuBul(ogrenciler);
        System.out.println("Birinci: " + enIyi.isim + " - " + enIyi.dakika + " dakika");

        Ogrenci ikinciEnIyi = ikinciEnIyiKosucuyuBul(ogrenciler, enIyi);
        System.out.println("İkinci: " + ikinciEnIyi.isim + " - " + ikinciEnIyi.dakika + " dakika");

        Ogrenci ucuncuEnIyi = ucuncuEnIyiKosucuyuBul(ogrenciler, enIyi, ikinciEnIyi);
        System.out.println("Üçüncü: " + ucuncuEnIyi.isim + " - " + ucuncuEnIyi.dakika + " dakika");

        Map<String, Integer> siniflandirma = siniflandirmaYap(ogrenciler);
        for (Map.Entry<String, Integer> entry : siniflandirma.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    public static Ogrenci enIyiKosucuyuBul(Ogrenci[] ogrenciler) {
        Ogrenci enIyi = ogrenciler[0];
        for (int i = 1; i < ogrenciler.length; i++) {
            if (ogrenciler[i].dakika < enIyi.dakika) {
                enIyi = ogrenciler[i];
            }
        }
        return enIyi;
    }

    public static Ogrenci ikinciEnIyiKosucuyuBul(Ogrenci[] ogrenciler, Ogrenci birinci) {
        Ogrenci ikinciEnIyi = ogrenciler[0];
        for (int i = 1; i < ogrenciler.length; i++) {
            if (ogrenciler[i].dakika < ikinciEnIyi.dakika && !ogrenciler[i].equals(birinci)) {
                ikinciEnIyi = ogrenciler[i];
            }
        }
        return ikinciEnIyi;
    }

    public static Ogrenci ucuncuEnIyiKosucuyuBul(Ogrenci[] ogrenciler, Ogrenci birinci, Ogrenci ikinci) {
        Ogrenci ucuncuEnIyi = ogrenciler[0];
        for (int i = 1; i < ogrenciler.length; i++) {
            if (ogrenciler[i].dakika < ucuncuEnIyi.dakika && !ogrenciler[i].equals(birinci) && !ogrenciler[i].equals(ikinci)) {
                ucuncuEnIyi = ogrenciler[i];
            }
        }
        return ucuncuEnIyi;
    }

    public static Map<String, Integer> siniflandirmaYap(Ogrenci[] ogrenciler) {
        Map<String, Integer> siniflandirma = new HashMap<>();
        siniflandirma.put("A", 0);
        siniflandirma.put("B", 0);
        siniflandirma.put("C", 0);

        for (Ogrenci ogrenci : ogrenciler) {
            if (ogrenci.dakika >= 200 && ogrenci.dakika <= 299) {
                siniflandirma.put("A", siniflandirma.get("A") + 1);
            } else if (ogrenci.dakika >= 300 && ogrenci.dakika <= 399) {
                siniflandirma.put("B", siniflandirma.get("B") + 1);
            } else if (ogrenci.dakika >= 400) {
                siniflandirma.put("C", siniflandirma.get("C") + 1);
            }
        }

        return siniflandirma;
    }
}

class Ogrenci {
    String isim;
    int dakika;

    public Ogrenci(String isim, int dakika) {
        this.isim = isim;
        this.dakika = dakika;
    }
}

