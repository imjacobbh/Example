package com.jacob.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacob.example.databinding.ActivityMainBinding
import com.jacob.example.databinding.ContactItemBinding
import com.squareup.picasso.Picasso

class ContactAdapter(val context: Context, val contactList : List<Contact>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    private lateinit var binding: ContactItemBinding
    inner class ContactHolder(view: View) : RecyclerView.ViewHolder(view){
        internal fun setData(contact : Contact){
            binding.tvContatName.text = contact.name
            binding.tvTel.text = contact.tel
            binding.imgBCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${contact.tel}"))
                context.startActivity(intent)
            }
            binding.imgSendMessage.setOnClickListener{
                val intent = Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:${contact.tel}"))
                context.startActivity(intent)
            }
            Picasso.with(context).load(contact.imgUrl).into(binding.imgContact)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        binding = ContactItemBinding.inflate(LayoutInflater.from(context))
        return ContactHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.setData(contactList[position])
    }

    override fun getItemCount(): Int = contactList.size
}