package com.mohaberabi.nativeapp

class NativeLib {

    /**
     * A native method that is implemented by the 'nativeapp' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'nativeapp' library on application startup.
        init {
            System.loadLibrary("nativeapp")
        }
    }
}