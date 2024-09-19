package id.mazafathi.ppidcapilkalteng.di

import id.mazafathi.ppidcapilkalteng.data.repositories.TrackingRepository
import org.koin.dsl.module

val repoModule = module {
    factory {
        TrackingRepository(get())
    }
}