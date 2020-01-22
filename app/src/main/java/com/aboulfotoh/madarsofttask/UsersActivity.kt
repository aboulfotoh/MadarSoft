package com.aboulfotoh.madarsofttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aboulfotoh.madarsofttask.adapters.UsersAdapter
import kotlinx.android.synthetic.main.activity_users.*

class UsersActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val adapter = UsersAdapter(this)
        rv_users.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
        userViewModel.allUsers.observe(this, Observer {users ->
            users?.let {
                adapter.setUsers(it)
            }
        })

    }
}
