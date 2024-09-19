package id.mazafathi.ppidcapilkalteng.di

import id.mazafathi.ppidcapilkalteng.ui.viewmodels.TrackingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TrackingViewModel(get())
    }
}