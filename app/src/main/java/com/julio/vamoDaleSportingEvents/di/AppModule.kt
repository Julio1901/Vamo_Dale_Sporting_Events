package com.julio.vamoDaleSportingEvents.di

import com.julio.vamoDaleSportingEvents.repository.MainRepository
import com.julio.vamoDaleSportingEvents.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {(mainRepository : MainRepository) -> MainViewModel(mainRepository) }

}