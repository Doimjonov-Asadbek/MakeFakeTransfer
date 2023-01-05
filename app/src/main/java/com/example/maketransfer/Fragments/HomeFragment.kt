package com.example.maketransfer.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maketransfer.R
import com.example.maketransfer.model.UserData
import com.example.maketransfer.view.UserAdapter

class HomeFragment : Fragment() {

    private lateinit var sendBtn: ImageButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private var userAdapter: UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendBtn = view.findViewById(R.id.sendImg)
        recv = view.findViewById(R.id.recyclerView)
        recv.layoutManager = LinearLayoutManager(context)
        userList = ArrayList()
        userAdapter = context?.let { UserAdapter(it, userList) }
        recv.adapter = userAdapter

        sendBtn.setOnClickListener {
            val inflater = LayoutInflater.from(context)
            val v = inflater.inflate(R.layout.add_list,null)
            val addDialog = context?.let { AlertDialog.Builder(it) }
            addDialog!!.setView(v)
            addDialog.create()
            val userPhone = v.findViewById<EditText>(R.id.userPhone)
            val userToken = v.findViewById<EditText>(R.id.userToken)
            addDialog.setPositiveButton("Send"){
                    dialog,_->
                val token = userToken?.text.toString()
                val phone = userPhone?.text.toString()
                userList.add(UserData("Phone: $phone", "Money: $token"))
                userAdapter?.notifyDataSetChanged()
                dialog.dismiss()
            }
            addDialog.setNegativeButton("Cancel"){ _, _->
            }
            addDialog.show()
        }

    }
}