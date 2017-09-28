package name.kocian.clean.domain.usecase

import name.kocian.clean.domain.repository.SampleRepository
import javax.inject.Inject

class SampleUseCase @Inject constructor(var repository: SampleRepository) {

    fun getSample(): String {
        return repository.getTest()
    }
}
