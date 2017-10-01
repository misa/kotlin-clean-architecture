package name.kocian.clean.domain.usecase

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AbstractUseCaseTest {

    @Test
    @DisplayName("Schedulers are set (not null)")
    fun testAsObservable() {
        val abstractUseCase = TestUseCase()

        assertThat(abstractUseCase.processScheduler).isNotNull()
        assertThat(abstractUseCase.resultScheduler).isNotNull()
    }

    class TestUseCase : AbstractUseCase<String>(Schedulers.trampoline(), Schedulers.trampoline()) {
        override fun buildObservable(): Observable<String> {
            return Observable.just("test")
        }
    }
}
