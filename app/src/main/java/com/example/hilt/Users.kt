package com.example.hilt

import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.ViewScoped
import javax.inject.Inject

@ActivityScoped
class Users constructor(var name: String) {
    @Inject
    constructor() : this("java") {
    }
}