package fr.isen.firstpackage.gothamcasino

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class ArticleActivity : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        Log.d("TAG", "entree")

        printData()
    }

    private fun printData(){
        db.collection("ArticleBase")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    Log.d("TAG", "Aricle :"+document.id + " => " + document.data)
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

}
