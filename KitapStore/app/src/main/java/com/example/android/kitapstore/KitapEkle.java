package com.example.android.kitapstore;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KitapEkle extends AppCompatActivity {
Button btnEkle;
    EditText edtKitapAdi,edtYazar,edtFiyat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_ekle);
        edtFiyat=(EditText)findViewById(R.id.editText_fiyat);
        edtKitapAdi=(EditText)findViewById(R.id.editText_kitapAdi);
        edtYazar=(EditText)findViewById(R.id.editText_yazar);

        btnEkle=(Button)findViewById(R.id.kaydet);
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edittext lerin boşmu dolumu diye kontrolü yapıldı.Eğer dolu ise fire base kaydı gerçekleşti
                if(edtFiyat.getText().toString().isEmpty()|| edtYazar.getText().toString().isEmpty()|| edtKitapAdi.getText().toString().isEmpty()){
                    AlertDialog.Builder alert=new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Uyarı").setMessage("Bütün Alanları Doldurunuz...").show();
                }
                else{

                    //eger edittextler dolu ise veeritabanına kayıt yapıyoruz, veritabanı kodları
                    DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference().child("kitaplar");//kitaplar adında bir child oluştur
                    uygModel model=new uygModel();
                    model.kitap=edtKitapAdi.getText().toString();
                    model.yazar=edtYazar.getText().toString();
                    model.fiyat=edtFiyat.getText().toString();

                    //model üzerinden veri ekle
                    dbRef.push().setValue(model);

                    //edittextlerin içini boşalt kaydettikten sonra
                    edtFiyat.setText(" ");
                    edtYazar.setText(" ");
                    edtKitapAdi.setText(" ");
                    Toast.makeText(getApplicationContext(), "Sisteme kaydedildi.", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
//Ctrl+O yapınca bu metodu oluştururuz
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menumüzü oluşturduk
       getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.kitapliste:
                Toast.makeText(getApplicationContext(), "Kitap Listesi", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(KitapEkle.this,KitapListesi.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
