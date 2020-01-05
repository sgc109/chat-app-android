package com.sungho.mychatapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.sungho.mychatapp.network.ChatService
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.LifecycleRegistry
import com.tinder.scarlet.messageadapter.moshi.MoshiMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

val appModule = module {
    single {
        OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    single {
        val lifecycleRegistry = LifecycleRegistry(0L)
        lifecycleRegistry.onNext(Lifecycle.State.Started)
        lifecycleRegistry
    }

    single {
        Scarlet.Builder()
                .lifecycle(get<LifecycleRegistry>())
                .webSocketFactory(get<OkHttpClient>().newWebSocketFactory("ws://10.0.2.2:8080"))
                .addMessageAdapterFactory(MoshiMessageAdapter.Factory())
                .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
                .build()
    }

    single { get<Scarlet>().create<ChatService>() }
}