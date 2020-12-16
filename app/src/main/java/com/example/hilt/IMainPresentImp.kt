package com.example.hilt

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class IMainPresentImp @Inject constructor() :IMainPresent {
    override fun doMainWork() {
        System.out.println("main work")
    }

    override fun doItemWork(index: Int) {
        System.out.println("item work $index")
    }
}