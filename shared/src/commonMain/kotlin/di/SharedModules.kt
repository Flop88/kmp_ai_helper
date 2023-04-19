package di

import data.ChatService
import data.RemoteDataSource
import data.repository.ChatRepositoryImpl
import domain.repository.ChatRepository
import domain.usecase.GetChatCompletionUseCase
import org.koin.dsl.module
import utils.provideDispatcher

private val dataModule = module {
    factory {
        RemoteDataSource(
            apiService = get(),
            dispatcher = get()
        )
    }
    factory { ChatService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<ChatRepository> {
        ChatRepositoryImpl(
            remoteDataSource = get()
        )
    }
    factory { GetChatCompletionUseCase() }
}

private val sharedModules = listOf(dataModule, domainModule, utilityModule)

fun getSharedModules() = sharedModules