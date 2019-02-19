package fr.isen.firstpackage.gothamcasino

data class ArticleModel(
    val userId: String,
    val title: String,
    val description: String,
    val photoUrl: String,
    val nbLike: Long,
    val nbDislike: Long
)