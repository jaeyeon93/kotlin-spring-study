package me.jimmy.hellospring.domain

import io.mockk.every
import io.mockk.mockk
import me.jimmy.hellospring.domain.user.User
import me.jimmy.hellospring.domain.user.UserReader
import me.jimmy.hellospring.domain.user.UserService
import me.jimmy.hellospring.domain.user.UserWriter
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserServiceTest {
    private val userWriter = mockk<UserWriter>()
    private val userReader = mockk<UserReader>()

    private val sut = UserService(userWriter, userReader)

    @Test
    fun `user를 id로 조회할 수 있다`() {
        every { userReader.read(any()) } returns
            User(
                id = 1L,
                name = "test",
            )

        val actual = sut.read(1L)

        assertNotNull(actual)
    }

    @Test
    fun `user가 없으면 NoSuchElementException를 던진다`() {
        every { userReader.read(any()) } returns null

        assertThrows<NoSuchElementException> {
            sut.read(1L)
        }
    }
}
