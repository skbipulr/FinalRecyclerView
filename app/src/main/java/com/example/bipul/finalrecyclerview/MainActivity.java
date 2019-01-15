package com.example.bipul.finalrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {

    EditText nameET, phoneNumberET;
    Button button;
    RecyclerView recyclerView;
    String name,phone;
    ArrayList<Contact> contactList;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.name);
        phoneNumberET = findViewById(R.id.phoneNumber);
        recyclerView = findViewById(R.id.recyclerView);
        contactList= new ArrayList<>();

    }

    public void createList(View view) {
        name = nameET.getText().toString();
        phone = phoneNumberET.getText().toString();
        Contact contact = new Contact(name,phone);
        contactList.add(contact);
        adapter = new ContactAdapter(MainActivity.this,contactList,this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onClick(Contact contact) {
        Toast.makeText(this, contact.getName(), Toast.LENGTH_SHORT).show();
    }
}
