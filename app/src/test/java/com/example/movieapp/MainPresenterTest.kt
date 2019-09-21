package com.example.movieapp

import com.example.movieapp.di.DependencyInjector
import com.example.movieapp.main.MainContract
import com.example.movieapp.main.MainPresenter
import com.example.movieapp.main.TrendListRepository
import com.example.movieapp.model.TrendDetail
import com.example.movieapp.model.Trending
import org.junit.After
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    private lateinit var mockMainActivity: MainContract.View

    private val dependencyInjector: DependencyInjector = StubDependencyInjector()

    private var presenter: MainPresenter? = null

    @Before
    fun setUp() {
        ​    MockitoAnnotations.initMocks(this)
        ​    presenter = MainPresenter(mockMainActivity, dependencyInjector)
    }

    @After
    fun tearDown() {
        ​    presenter?.onDestroy()
    }

    @Test
    suspend fun testOnViewCreatedFlow() {
        ​    presenter?.onViewCreated()
        ​    verify(mockMainActivity).displayTrendList(
            dependencyInjector.trendListRepository().loadTrendList(
                1
            )
        )
    }
}

class StubDependencyInjector : DependencyInjector {
    override fun trendListRepository(): TrendListRepository {
        return StubTrendRepository()
    }

}

class StubTrendRepository : TrendListRepository {
    override suspend fun loadTrendList(page: Long): Trending? {
        return Trending(
            1,
            listOf(
                TrendDetail(
                    title = "title",
                    posterPath = "/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                    mediaType = "movie"

                ),
                TrendDetail(
                    title = "title",
                    posterPath = "/lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                    mediaType = "movie"
                )

            ),
            10, 10
        )
    }

}