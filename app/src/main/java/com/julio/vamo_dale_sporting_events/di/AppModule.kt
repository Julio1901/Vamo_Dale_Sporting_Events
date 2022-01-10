package com.julio.vamo_dale_sporting_events.di

import com.julio.vamo_dale_sporting_events.repository.MainRepository
import com.julio.vamo_dale_sporting_events.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {(mainRepository : MainRepository) -> MainViewModel(mainRepository) }

}