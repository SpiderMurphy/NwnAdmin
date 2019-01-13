package cyan.com.nwnadmin.main

import cyan.com.nwnadmin.model.Repository

class MainPresenterImpl(
    private var view: MainView?,
    private var model: Repository
) : MainPresenter {
    override fun viewReady() {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        view = null
    }
}