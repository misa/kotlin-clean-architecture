package name.kocian.clean.datasource.repository

import name.kocian.clean.domain.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor() : SampleRepository {

    override fun getTest(): String {
        return "test"
    }
}
