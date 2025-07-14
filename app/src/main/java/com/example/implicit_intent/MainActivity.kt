package com.example.implicit_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.implicit_intent.databinding.ActivityMainBinding
import android.view.LayoutInflater
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openweb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/"))
            startActivity(intent)
        }

        binding.opencall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+916523958546")
            startActivity(intent)
        }

        binding.opencamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

            // 4. Create share intent
            binding.editTextText.setOnClickListener {
                val text = binding.editTextText.text.toString()
                // Corrected Toast (using 'this' instead of 'context' in an Activity)
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(intent, "Share via"))
            }
    }
}