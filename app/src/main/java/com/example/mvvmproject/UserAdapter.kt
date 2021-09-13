package com.example.mvvmproject

import android.view.*
import androidx.recyclerview.widget.*
import com.example.mvvmproject.db.*
import kotlinx.android.synthetic.main.user_item_view.view.*


class UserAdapter(private val userList: List<UserEntity>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(userEntity: UserEntity) {
            itemView.user_id.text = userEntity.id.toString()
            itemView.user_name.text = userEntity.name
            itemView.user_email.text = userEntity.email
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}