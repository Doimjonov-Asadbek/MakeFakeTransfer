package com.example.maketransfer.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maketransfer.R
import com.example.maketransfer.model.UserData

class UserAdapter(val c:Context,var userList: ArrayList<UserData>): RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{

    inner class UserViewHolder(val v:View): RecyclerView.ViewHolder(v){
        var number = v.findViewById<TextView>(R.id.mPhone)
        var token = v.findViewById<TextView>(R.id.mToken)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item,parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.number.text = newList.phoneNumber
        holder.token.text = newList.token
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}