package cyan.com.nwnadmin.characters.details

import cyan.com.nwnadmin.model.data.PlayerCharacter
import io.mockk.CapturingSlot
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CharacterDetailPresenterImplTest {
    @RelaxedMockK
    private lateinit var view: CharacterDetailView
    private lateinit var presenter: CharacterDetailPresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        val character = PlayerCharacter(
            1,
            "testusername",
            "testcdkey",
            "testname",
            0,
            15)

        presenter = CharacterDetailPresenterImpl(view, character)
    }

    @Test
    fun viewReady() {
        val slot = CapturingSlot<PlayerCharacter>()
        presenter.viewReady()
        verify { view.onDisplayCharacter(capture(slot)) }
        assert(slot.captured.username == "testusername")
    }

    @Test
    fun destroy() {
    }
}