package fr.isen.firstpackage.gothamcasino

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        publiButton.setOnClickListener{
            onPublish()
        }

        returnButton.setOnClickListener{
            val intent = Intent(this, WallActivity::class.java)
            startActivity(intent)
        }

    }


    private fun onPublish() {
        var commentText: String = inputComment.text.toString()
        var titleText: String = inputText.text.toString()
        Toast.makeText(this, commentText, Toast.LENGTH_LONG).show()

        val article = HashMap<String, Any>()
        article["userId"] = "myId"
        article["title"] = titleText
        article["description"] = commentText
        article["photoUrl"] = ""
        article["nbLike"] = 0
        article["nbDislike"] = 0

        val db = FirebaseFirestore.getInstance()
        db.collection("ArticleBase")
            .add(article)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot written with ID: " + documentReference.id)
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

}
