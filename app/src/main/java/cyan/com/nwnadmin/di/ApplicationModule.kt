package cyan.com.nwnadmin.di

import android.app.Application
import android.content.Context
import cyan.com.nwnadmin.R
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideRetrofit(context: Context): Retrofit = Retrofit.Builder()
        .baseUrl(context.resources.getString(R.string.api_endpoint))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}