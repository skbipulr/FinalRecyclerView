package com.example.bipul.finalrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    Context context;
    ArrayList<Contact> contactList;
    ClickListener listener;

    public ContactAdapter(Context context, ArrayList<Contact> contactList,ClickListener listener) {
        this.context = context;
        this.contactList = contactList;
        this.listener =listener;
    }

    @NonNull
    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        Contact contact = contactList.get(position);
        myViewHolder.nameTv.setText(contact.getName());
        myViewHolder.phoneNumberTv.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv,phoneNumberTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTV);
            phoneNumberTv = itemView.findViewById(R.id.phoneNumberTV);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(contactList.get(getAdapterPosition()));
                }
            });

        }
    }

    public void  updateData(ArrayList<Contact> contactList){
        this.contactList=contactList;
        notifyDataSetChanged();
    }
}
