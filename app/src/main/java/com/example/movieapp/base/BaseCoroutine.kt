package com.example.movieapp.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext

abstract class BaseCoroutine : CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = Main

    val uiScope = CoroutineScope(Main)

    val bgScope = CoroutineScope(IO)

    val bgDispatcher: CoroutineDispatcher = IO

    val uiDispatcher: CoroutineDispatcher = Main


}