package fr.isen.firstpackage.gothamcasino

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_wall.*

class WallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        val articles = ArrayList<ArticleModel>()
        for (i in 0..20) {
            val tempComments = arrayListOf<CommentModel>()
            val tempArticle = ArticleModel(i,i,"Titre $i","Description $i","url $i",i*48196452,i*1456, tempComments)
            // new item
            articles.add(tempArticle)
        }

        articleView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val adapter = CustomAdapter(articles)
        articleView.adapter = adapter
    }



}
