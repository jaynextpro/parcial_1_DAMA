package com.example.parcial1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EngineerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_engineer_detail)

        val engineer = intent.getParcelableExtra<Engineer>("engineer")

        val imageView = findViewById<ImageView>(R.id.imageViewEngineerDetail)
        val nameTextView = findViewById<TextView>(R.id.textViewNameDetail)
        val specialtyTextView = findViewById<TextView>(R.id.textViewSpecialtyDetail)
        val aboutTextView = findViewById<TextView>(R.id.textViewAboutDetail)
        val emailTextView = findViewById<TextView>(R.id.textViewEmailDetail)
        val phoneTextView = findViewById<TextView>(R.id.textViewPhoneDetail)
        val experienceTextView = findViewById<TextView>(R.id.textViewExperienceDetail)
        val projectsTextView = findViewById<TextView>(R.id.textViewProjectsDetail)
        val callButton = findViewById<Button>(R.id.buttonCall)
        val whatsAppButton = findViewById<Button>(R.id.buttonWhatsApp)

        imageView.setImageResource(engineer?.imageResId ?: R.drawable.engineer_placeholder)
        nameTextView.text = engineer?.name
        specialtyTextView.text = engineer?.specialty
        aboutTextView.text = engineer?.about
        emailTextView.text = "Email: ${engineer?.email}"
        phoneTextView.text = "Phone: ${engineer?.phone}"

        experienceTextView.text = "EXP years: ${engineer?.experience}"
        projectsTextView.text = "Projects: ${engineer?.projects}"

        callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${engineer?.phone}")
            startActivity(intent)
        }

        whatsAppButton.setOnClickListener {
            val uri = Uri.parse("https://wa.me/${engineer?.phone}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}
