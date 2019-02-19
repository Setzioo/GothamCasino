package fr.isen.firstpackage.gothamcasino

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        publiButton.setOnClickListener{
            onPublish()
        }

    }

    private fun onPublish() {
        var commentText: String = inputComment.text.toString()
        var titleText: String = inputText.text.toString()
        Toast.makeText(this, commentText, Toast.LENGTH_LONG).show()
    }

}
