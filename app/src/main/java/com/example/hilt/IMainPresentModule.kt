package com.example.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class IMainPresentModule {
    @Binds
    abstract fun bind(iMainPresentImp: IMainPresentImp): IMainPresent
}