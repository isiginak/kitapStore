package com.example.android.kitapstore;

/**
 * Created by HP on 17.6.2017.
 */
//uygulamayı firebase bağlarken bir model oluşturmamız gerekiyor bu model üzerinden kayıt yapıyoruz firebase e
public class uygModel {
    String yazar,kitap,fiyat;
    public uygModel(){

    }

    public uygModel(String yazar, String kitap, String fiyat) {
        this.yazar = yazar;
        this.kitap = kitap;
        this.fiyat = fiyat;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getKitap() {
        return kitap;
    }

    public void setKitap(String kitap) {
        this.kitap = kitap;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
}
