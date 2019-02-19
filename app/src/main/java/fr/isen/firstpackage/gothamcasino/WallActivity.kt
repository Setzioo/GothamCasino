package fr.isen.firstpackage.gothamcasino

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_wall.*


class WallActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        postButton.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }

        val articles = ArrayList<ArticleModel>()



        articleView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        Log.d("TAG", articles.toString())

        val adapter = CustomAdapter(articles)
        articleView.adapter = adapter

        val db = FirebaseFirestore.getInstance()

        var tempArticleModel:ArticleModel

        db.collection("ArticleBase")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("TAG", document.id + " => " + document.data)

                        val tempArticleModel = ArticleModel(document.data["userId"] as String,document.data["title"] as String,document.data["description"] as String,document.data["photoUrl"] as String,document.data["nbLike"] as Long,document.data["nbDislike"] as Long)
                        articles.add(tempArticleModel)
                        Log.d("TAG", articles.toString())
                        (articleView.adapter as CustomAdapter).notifyDataSetChanged()
                    }
                } else {
                    Log.w("TAG", "Error getting documents.", task.exception)
                }
            }
    }


}
