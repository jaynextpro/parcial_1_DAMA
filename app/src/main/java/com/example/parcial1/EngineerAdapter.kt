package com.example.parcial1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class EngineerAdapter(private var engineerList: List<Engineer>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<EngineerAdapter.EngineerViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(engineer: Engineer)
    }

    inner class EngineerViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardViewEngineer)
        val imageView: ImageView = itemView.findViewById(R.id.imageViewEngineer)
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val specialtyTextView: TextView = itemView.findViewById(R.id.textViewSpecialty)
        val experienceTextView: TextView = itemView.findViewById(R.id.textViewExperience)
        val projectsTextView: TextView = itemView.findViewById(R.id.textViewProjects)

        fun bind(engineer: Engineer, position: Int) {
            imageView.setImageResource(engineer.imageResId)
            nameTextView.text = engineer.name
            specialtyTextView.text = engineer.specialty
            experienceTextView.text = "${engineer.experience} Years"
            projectsTextView.text = "${engineer.projects} "

            val backgroundColors = arrayOf(
                Color.parseColor("#6A0DAD"),
                Color.parseColor("#0052CC"),
                Color.parseColor("#0EAD69"),
                Color.parseColor("#F4A261")
            )

            val textColors = arrayOf(
                Color.parseColor("#FFFFFF"),
                Color.parseColor("#FFFFFF"),
                Color.parseColor("#000000"),
                Color.parseColor("#000000")
            )

            cardView.setCardBackgroundColor(backgroundColors[position % backgroundColors.size])

            val textColor = textColors[position % textColors.size]
            nameTextView.setTextColor(textColor)
            specialtyTextView.setTextColor(textColor)
            experienceTextView.setTextColor(textColor)
            projectsTextView.setTextColor(textColor)

            itemView.setOnClickListener {
                listener.onItemClick(engineer)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_engineer, parent, false)
        return EngineerViewHolder(view)
    }

    override fun onBindViewHolder(holder: EngineerViewHolder, position: Int) {
        holder.bind(engineerList[position], position)
    }

    override fun getItemCount(): Int = engineerList.size

    fun updateEngineerList(newEngineerList: List<Engineer>) {
        engineerList = newEngineerList
        notifyDataSetChanged()
    }
}
