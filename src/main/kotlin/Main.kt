package ru.netology

data class Comments(
    val count: Int = 0,
    val canPost: Int = 0,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Post(
    val id: Int,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val markedAsAds: Boolean = false
)

class WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 1

    fun add(post: Post): Post {
        posts += post.copy(id = nextId++)
        return posts.last()
    }

    fun update(id: Int): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(id = nextId++)
                return true
            }
        }
        return false
    }
}

fun main() {
}