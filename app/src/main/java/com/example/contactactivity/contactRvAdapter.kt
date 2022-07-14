package com.example.contactactivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactactivity.databinding.ContactListBinding

class ContactRvAdapter(var contactList:List<contactList>):
    RecyclerView.Adapter<ContactRvAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding =
            ContactListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ContactViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        val context = holder.itemView.context
        with(holder.binding) {
            tvName.text = currentContact.name
            tvEmail.text = currentContact.email
            tvAddress.text = currentContact.address
            tvNumber.text = currentContact.Phonenumber
            Picasso.get()
                .load(currentContact.Person)
//                .resize(300,300)
//                .centerCrop()
//                .placeholder(R.drawable.)
//                .error(R.drawable.ic_launcher_background)
                .into(imgPerson)
            cvAvatar.setOnClickListener {
                val context = holder.itemView.context
                val intent = Intent(context, contactViewActivity::class.java)
                intent.putExtra("NAME", currentContact.Name)
                intent.putExtra("NUMBER", currentContact.Number)
                intent.putExtra("EMAIL", currentContact.Email)
                intent.putExtra("ADDRESS", currentContact.Address)
                intent.putExtra("PERSON", currentContact.Person)


                context.startActivity(intent)
            }
//            holder.binding.cvContact.setOnClickListener {
//                Toast
//                    .makeText(context,"You have clicked on my face",Toast.LENGTH_LONG)
//                    .show()
//            }
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }


    class ContactViewHolder(var binding: ContactListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}