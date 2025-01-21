import org.junit.Assert.*
import ru.netology.Post
import org.junit.Test
import ru.netology.WallService

class WallServiceTest {

    @Test
    fun addId() {

        val service = WallService()
        val post = Post(1)
        val result = service.add(Post(0))

        assertEquals(result, post)
    }

    @Test
    fun updateExisting() {

        val service = WallService()

        service.add(Post(1))
        service.add(Post(2))
        service.add(Post(3))

        val result = service.update(1)

        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {

        val service = WallService()

        service.add(Post(1))
        service.add(Post(2))
        service.add(Post(3))

        val result = service.update(4)

        assertFalse(result)
    }
}