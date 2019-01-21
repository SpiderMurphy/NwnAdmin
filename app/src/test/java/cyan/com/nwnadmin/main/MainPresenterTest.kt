package cyan.com.nwnadmin.main

import cyan.com.nwnadmin.main.utils.ExecutorServiceSyncTest
import cyan.com.nwnadmin.model.Repository
import cyan.com.nwnadmin.model.data.PlayerCharacter
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.BeforeClass
import org.mockito.Mockito
import org.mockito.Mockito.mock

class MainPresenterTest {
    lateinit var view: MainView
    lateinit var presenter: MainPresenter

    companion object {
        @JvmStatic
        lateinit var model: Repository

        @JvmStatic
        val testScheduler = TestScheduler()

        @JvmStatic
        @BeforeClass
        fun setupTestClass() {
            model = mock(Repository::class.java)
            var character = PlayerCharacter(1, "test", "TESTKEY", "Test", 0, 0)
            Mockito.`when`(model.fetchCharacterAll()).thenReturn(
                Single.just(listOf(character)).compose(
                    ExecutorServiceSyncTest(testScheduler)
                        .singleThreadExecutor()
                )
            )
            Mockito.`when`(model.fetchCharacterByCdkey("TESTKEY")).thenReturn(
                Single.just(listOf(character)).compose(
                    ExecutorServiceSyncTest(testScheduler)
                        .singleThreadExecutor()
                )
            )
            Mockito.`when`(model.fetchCharacterByUsername("test")).thenReturn(
                Single.just(listOf(character)).compose(
                    ExecutorServiceSyncTest(testScheduler)
                        .singleThreadExecutor()
                )
            )
        }
    }

    @Before
    fun setupTest() {
        view = Mockito.mock(MainView::class.java)
        presenter = MainPresenterImpl(view, model)
    }
}