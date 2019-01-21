package cyan.com.nwnadmin.main

import cyan.com.nwnadmin.characters.CharacterListPresenter
import cyan.com.nwnadmin.characters.CharacterListPresenterImpl
import cyan.com.nwnadmin.characters.CharacterListView
import cyan.com.nwnadmin.main.utils.ExecutorServiceSyncTest
import cyan.com.nwnadmin.model.Repository
import cyan.com.nwnadmin.model.data.PlayerCharacter
import io.mockk.CapturingSlot
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

class CharacterListPresenterTest {
    @RelaxedMockK
    lateinit var view: CharacterListView

    @RelaxedMockK
    lateinit var model: Repository

    lateinit var presenter: CharacterListPresenter

    val scheduler = TestScheduler()

    @Before
    fun setupYest() {
        MockKAnnotations.init(this)
        every { model.fetchCharacterAll() }.returns(
            Single.just(
                listOf(PlayerCharacter(
                        1,
                        "testusername",
                        "testcdkey",
                        "testname",
                        0,
                        100
                    ),
                    PlayerCharacter(
                        2,
                        "testusername2",
                        "testcdkey2",
                        "testname2",
                        100,
                        200
                    )
                )).compose(ExecutorServiceSyncTest(scheduler).singleThreadExecutor()))
        every { model.fetchCharacterByCdkey("testcdkey") }.returns(
            Single.just(
                listOf(PlayerCharacter(
                    2,
                    "testusername",
                    "testcdkey",
                    "testname",
                    100,
                    200
                ))
            ).compose(ExecutorServiceSyncTest(scheduler).singleThreadExecutor()))
        every { model.fetchCharacterByUsername("testusername") }.returns(
            Single.just(
                listOf(PlayerCharacter(
                    1,
                    "testusername",
                    "testcdkey",
                    "testname",
                    0,
                    100
                    ))).compose(ExecutorServiceSyncTest(scheduler).singleThreadExecutor()))

        presenter = CharacterListPresenterImpl(view, model)
    }

    @Test
    fun fetchCharacters_With2Characters_Successful() {
        var slot = CapturingSlot<List<PlayerCharacter>>()
        presenter.fetchCharacters()
        scheduler.triggerActions()
        verify { view.onFetchCharacter(capture(slot)) }
        assert(slot.captured.size == 2)
    }

    @Test
    fun fetchCharactersByUsername_With1Character_Successful() {
        var slot = CapturingSlot<List<PlayerCharacter>>()
        presenter.fetchCharactersByUsername("testusername")
        scheduler.triggerActions()
        verify { view.onFetchCharacter(capture(slot)) }
        assert(slot.captured[0].username == "testusername")
    }

    @Test
    fun fetchCharactersByCdkey_With1Character_Successful() {
        var slot = CapturingSlot<List<PlayerCharacter>>()
        presenter.fetchCharactersByCdKey("testcdkey")
        scheduler.triggerActions()
        verify { view.onFetchCharacter(capture(slot)) }
        assert(slot.captured[0].cdkey == "testcdkey")
    }
}