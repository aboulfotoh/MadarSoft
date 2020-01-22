package com.aboulfotoh.madarsofttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aboulfotoh.madarsofttask.data.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private var gender = "male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btn_save.setOnClickListener {
            saveUser()
        }

        btn_users.setOnClickListener {
            startActivity(Intent(this,UsersActivity::class.java))
        }
        rb_female.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                gender = "female"
        }
        rb_male.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                gender = "male"
        }

    }

    private fun saveUser() {
        when {
            et_user_name.text.isEmpty() -> {
                et_user_name.apply {
                    requestFocus()
                    error = "Required filed"
                }
            }
            et_user_age.text.isEmpty() -> {
                et_user_age.apply {
                    requestFocus()
                    error = "Required Filed"
                }
            }
            et_user_job_title.text.isEmpty() -> {
                et_user_job_title.apply {
                    requestFocus()
                    error = "Required Filed"
                }
            }
            else -> {
                val user = User(0,et_user_name.text.toString(),et_user_age.text.toString(),et_user_job_title.text.toString(),gender)
                userViewModel.insert(user)
                startActivity(Intent(this,UsersActivity::class.java))
            }
        }
    }
}
