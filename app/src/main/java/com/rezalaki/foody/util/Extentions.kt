package com.rezalaki.foody.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> LiveData<T>.onceObserve(owner: LifecycleOwner, observe: Observer<T>) {
    observe(owner, object : Observer<T> {
        override fun onChanged(t: T) {
            removeObserver(this)
            observe.onChanged(t)
        }
    })
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.enterByScaleAnimation(){
    ScaleAnimation(
        0.0f,
        1.0f,
        0.0f,
        1.0f,
        Animation.RELATIVE_TO_SELF,
        0.5f,
        Animation.RELATIVE_TO_SELF,
        0.95f
    ).also {
        it.duration = 400
        this.startAnimation(it)
    }
}