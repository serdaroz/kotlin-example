package com.example.movieapp

import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

   /* @Mock
    private lateinit var mockMainActivity: MainContract.View

    private val dependencyInjector: RepositoryInjector = StubDependencyInjector()

    private var presenter: MainPresenter? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(dependencyInjector)
    }


    @Test
    fun testOnViewCreatedFlow() {
        ​presenter?.onViewCreated()
        ​GlobalScope.launch(Dispatchers.Main) {
            verify(mockMainActivity).displayTrendList(
                dependencyInjector.trendListRepository().loadTrendList(1)
            )
        }
    }
}

class StubDependencyInjector : RepositoryInjector {
    override fun trendListRepository(): TrendListRepository {
        return StubTrendRepository()
    }

    override fun movieDetailRepository(): MovieDetailRepository {

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
    }*/

}