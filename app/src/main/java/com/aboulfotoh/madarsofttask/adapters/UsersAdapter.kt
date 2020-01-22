package com.aboulfotoh.madarsofttask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aboulfotoh.madarsofttask.R
import com.aboulfotoh.madarsofttask.data.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter internal constructor(context: Context) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>()
    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersViewHolder {
        val itemView = inflater.inflate(R.layout.item_user, parent, false)
        return UsersViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.itemView.tv_user_name.text = users[position].userName
        holder.itemView.tv_user_job_title.text = users[position].jobTitle
        holder.itemView.tv_user_age.text = users[position].age
        holder.itemView.tv_user_gender.text = users[position].gender
    }

    internal fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}