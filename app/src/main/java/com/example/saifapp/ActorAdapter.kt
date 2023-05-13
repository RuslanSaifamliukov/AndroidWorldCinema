package com.example.saifapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter (val con:Context, val list4:ArrayList<Actor>):RecyclerView.Adapter<ActorAdapter.Link>() {
    class Link(itemView: View):RecyclerView.ViewHolder(itemView) {
        val im_di: ImageView = itemView.findViewById(R.id.imageActor)
        val text_di: TextView = itemView.findViewById(R.id.nameActor)
        val text_di2: TextView = itemView.findViewById(R.id.titleActor)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorAdapter.Link {
        val root = LayoutInflater.from(con).inflate(R.layout.actor_list, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: ActorAdapter.Link, position: Int) {
        holder.im_di.setImageResource(list4[position].imageActorId)
        holder.text_di.setText(list4[position].nameActor)
        holder.text_di2.setText(list4[position].titleActor)
    }

    override fun getItemCount(): Int {
        return list4.size
    }
}