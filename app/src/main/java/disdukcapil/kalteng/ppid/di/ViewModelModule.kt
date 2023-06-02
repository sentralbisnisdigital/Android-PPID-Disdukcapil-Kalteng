package disdukcapil.kalteng.ppid.di

import disdukcapil.kalteng.ppid.ui.viewmodels.TrackingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TrackingViewModel(get())
    }
}