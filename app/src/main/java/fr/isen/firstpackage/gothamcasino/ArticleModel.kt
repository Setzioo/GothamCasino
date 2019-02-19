package fr.isen.firstpackage.gothamcasino

data class ArticleModel(
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String,
    val photoUrl: String,
    val nbLike: Int,
    val nbDislike: Int,
    val comments: List<CommentModel>
)