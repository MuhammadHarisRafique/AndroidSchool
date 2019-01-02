package com.example.visibility.myapplication123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;


import org.bson.Document;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.connect);
        btn.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {

        String name = "Loading";
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://192.168.1.103:27017"));
           MongoDatabase database = mongoClient.getDatabase("SchoolManagement");

          if (database != null){

              MongoCollection<Document> coll = database.getCollection("Userdata");
              coll.drop();

        }



//        for (String nam : database.listCollectionNames()) {
//            TextView txt = (TextView) findViewById(R.id.abc);
//            txt.setText(nam);
//            System.out.println(nam);
//        }



    }
}
