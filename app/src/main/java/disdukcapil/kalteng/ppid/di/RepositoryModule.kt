package disdukcapil.kalteng.ppid.di

import disdukcapil.kalteng.ppid.repositories.TrackingRepository
import org.koin.dsl.module

val repoModule = module {
    factory {
        TrackingRepository(get())
    }
}