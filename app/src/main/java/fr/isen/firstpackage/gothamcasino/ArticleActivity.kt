package fr.isen.firstpackage.gothamcasino

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()
    val selected = "DefaultArticle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        db.collection("ArticleBase").document(selected).get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    if (document.data != null) {
                        articleTitle.text = document.data!!["title"] as String
                        articleText.text = document.data!!["description"] as String
                        nbLike.text = (document.data!!["nbLike"] as Long).toString()
                        nbDislike.text = (document.data!!["nbDislike"] as Long).toString()

                        db.collection("userId").document(document.data!!["userId"] as String).get()
                            .addOnSuccessListener { user ->
                                Log.d("tag","firstName" +  user.data!!["firstName"] as String)
                                if (user != null) {
                                    if (user.data != null) {
                                        firstName.text = user.data!!["firstName"] as String
                                        lastName.text = user.data!!["lastName"] as String
                                        Log.d("tag","firstName" +  user.data!!["firstName"] as String)
                                    }
                                }
                            }
                            .addOnFailureListener { exception ->
                                Log.d("TAG", "get failed with ", exception)
                            }
                    } else {
                        Log.d("TAG", "no data in user")
                    }
                } else {
                    Log.d("TAG", "no data article")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "get failed with ", exception)
            }
        }
    }
