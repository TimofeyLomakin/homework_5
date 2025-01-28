package ru.netology

interface Attachment {
        val type: String
}

data class Photo (
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String = ""
)

class PhotoAttachment (
    override val type: String = "photo",
    val photo: Photo
) : Attachment

data class Video (
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val description: String = "",
    val duration: Int = 0
)

class VideoAttachment (
    override val type: String = "video",
    val video: Video
) : Attachment

data class Audio (
    val id: Int = 0,
    val ownerId: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0
)

class AudioAttachment (
    override val type: String = "audio",
    val audio: Audio
) : Attachment

data class Document (
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = ""
)

class DocumentAttachment (
    override val type: String = "document",
    val document: Document
) : Attachment

data class Link (
    val url: String = "",
    val title: String = "",
    val caption: String = "",
    val description: String = ""
)

class LinkAttachment (
    override val type: String = "link",
    val link: Link
) : Attachment


data class Comments(
    val count: Int = 0,
    val canPost: Int = 0,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Post(
    val id: Int = 0,
    val ownerId: Int? = null,
    val fromId: Int? = null,
    val createdBy: Int? = null,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val markedAsAds: Boolean = false,
    val attachment: List<Attachment> = emptyList()
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