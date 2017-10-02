package name.kocian.clean.datasource.repository

import name.kocian.clean.domain.repository.SampleRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.MockitoAnnotations

class SampleRepositoryImplTest {
    private lateinit var repository: SampleRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        repository = SampleRepositoryImpl()
    }

    @Test
    @DisplayName("getTest # returns sample text")
    fun getTest() {
        repository.getTest()
                .test()
                .assertValueCount(1)
                .assertValue("test")
                .assertNoErrors()
                .assertComplete()
    }
}
