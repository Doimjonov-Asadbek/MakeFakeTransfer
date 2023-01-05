package com.example.maketransfer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maketransfer.Fragments.*
import com.example.maketransfer.model.UserData
import com.example.maketransfer.view.UserAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {

    /*private lateinit var sendBtn:ImageButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter*/

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home_page)
/*
        sendBtn = findViewById(R.id.sendImg)
        recv = findViewById(R.id.recyclerView)
        recv.layoutManager = LinearLayoutManager(this)
        userList = ArrayList()
        userAdapter = UserAdapter(this,userList)
        recv.adapter = userAdapter

        sendBtn.setOnClickListener {
            sendToken()
        }*/

        replaceFragment(HomeFragment())
        val bottomNavigationBar = findViewById<BottomNavigationView>(R.id.bottomNavigationBar)

        bottomNavigationBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    @SuppressLint("NotifyDataSetChanged")/*
    private fun sendToken() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.add_list,null)
        val addDialog = AlertDialog.Builder(this)
        val userPhone = findViewById<EditText>(R.id.userPhone)
        val userToken = findViewById<EditText>(R.id.userToken)
        addDialog.setView(v)
        addDialog.setPositiveButton("Send"){
            dialog,_->
            val phone = userPhone.text.toString()
            val token = userToken.text.toString()
            userList.add(UserData("Phone: $phone", "Token: $token"))
            userAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                _, _->
        }
        addDialog.create()
        addDialog.show()
    }*/

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}