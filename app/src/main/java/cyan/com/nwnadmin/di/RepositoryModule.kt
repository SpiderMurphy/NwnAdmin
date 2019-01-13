package cyan.com.nwnadmin.di

import cyan.com.nwnadmin.model.AdminApi
import cyan.com.nwnadmin.model.ExecutorServiceAsync
import cyan.com.nwnadmin.model.RemoteRepository
import cyan.com.nwnadmin.model.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): AdminApi = retrofit.create(AdminApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(apiService: AdminApi): Repository = RemoteRepository(apiService, ExecutorServiceAsync())
}