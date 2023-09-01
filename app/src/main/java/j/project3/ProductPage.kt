package j.project3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class ProductPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_page)

        val backButton = findViewById<ImageView>(R.id.backbtn)
        backButton.setOnClickListener {
            finish()
        }
    }
}
