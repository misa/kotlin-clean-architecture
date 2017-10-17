package name.kocian.clean.datasource.repository

import name.kocian.clean.domain.repository.SampleRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleRepositoryImplTest {
    private lateinit var repository: SampleRepository

    @Before
    fun setUp() {
        repository = SampleRepositoryImpl()
    }

    @Test
    fun getTestReturnsSampleText() {
        repository.getTest()
                .test()
                .assertValueCount(1)
                .assertValue("test")
                .assertNoErrors()
                .assertComplete()
    }
}
