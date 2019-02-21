package com.example.parul.expensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Grocery extends AppCompatActivity {
    private EditText itemb, quantb, priceb, dayb;
    private Button submitb;
    public static final String Database_Path = "expensemanager-6c01b";
    public static final String Firebase_Server_UR="https://expensemanager-6c01b.firebaseio.com/";
    FirebaseDatabase database;
    DatabaseReference myRef;
    String item,day;
    int price,quant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // String x = UUID.randomUUID().toString();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);
        itemb = (EditText) findViewById(R.id.item);
        quantb = (EditText) findViewById(R.id.quantity);
        priceb = (EditText) findViewById(R.id.price);
        dayb = (EditText) findViewById(R.id.day);
        submitb = (Button) findViewById(R.id.submit);


       /* try {
            item1 = item.getText().toString().trim();
            day1 = day.getText().toString().trim();
            try {
                quant1 = Integer.parseInt(quant.getText().toString());
            }
            catch (NumberFormatException e) {
                quant1=0;
                Log.d("myTag", "This is my message");
            }
            try {
                price1 = Integer.parseInt(price.getText().toString());
            } catch (NumberFormatException e) {
                // handle the exception

                 price1=0;
                Log.d("myTag", "This is my message");
            }
            List ob = new List(item1, "ghsgja", day1, quant1, price1);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();
            myRef.setValue(ob);
        } catch (NullPointerException e) {
            Log.d("myTag", "This is my message");
        }
        System.out.print(quant1+" "+price1+" "+item1);*/
        myRef= FirebaseDatabase.getInstance().getReference(Database_Path);
        submitb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String x = UUID.randomUUID().toString();
                List ob = new List();
                GetDataFromEditText();
                ob.setItem(item);
                ob.setPrice(price);
                ob.setQuan(quant);
                ob.setDay(day);
                ob.setUniqueId(x);

                String Id = myRef.push().getKey();
                myRef.child(Id).setValue(ob);
                Toast.makeText(Grocery.this,"Data Inserted Successfully into Firebase Database", Toast.LENGTH_LONG).show();

            }
        });
    }
    public void GetDataFromEditText(){

        item = itemb.getText().toString().trim();
        day = dayb.getText().toString().trim();
        quant = Integer.parseInt(quantb.getText().toString());
        price = Integer.parseInt(priceb.getText().toString());

    }

}
