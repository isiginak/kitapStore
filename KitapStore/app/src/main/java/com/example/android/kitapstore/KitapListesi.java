package com.example.android.kitapstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class KitapListesi extends AppCompatActivity {
ListView kitapEkle;
    ArrayAdapter adapter;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_listesi);
        kitapEkle=(ListView)findViewById(R.id.listKitap);
        arrayList=new ArrayList<>();
        //dizimizi adaptöre atıyoruz
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
        //veritabanı kısmı
        DatabaseReference dbref= FirebaseDatabase.getInstance().getReference().child("kitaplar");//firebase den veri çekeceğimizi söyledik
    dbref.addValueEventListener(new ValueEventListener() {
        // veri çekerken bir hata olursa aşağıdaki metot içinde işlemler yapıyoruz
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot ds:dataSnapshot.getChildren()){
                dataSnapshot.getKey();//gezilen verilerin id sini gösterir
                uygModel model=ds.getValue(uygModel.class);
                arrayList.add("Kitap Adı: "+model.getKitap());//kitap isminni listviewda gösterecez


            }
            kitapEkle.setAdapter(adapter);
            //listviewa veri atabilmek için setAdapter metodu kullanılır.
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    }
}
