package fr.isen.firstpackage.gothamcasino

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomAdapter(private val articles: ArrayList<ArticleModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = articles[position].title
        holder.likes.text = "Likes : " + articles[position].nbLike.toString()
        holder.dislikes.text = "Dislikes : " + articles[position].nbDislike.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.fragment_article_view_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.titleText)
        var likes: TextView = itemView.findViewById(R.id.likeText)
        var dislikes: TextView = itemView.findViewById(R.id.dislikeText)

    }
}