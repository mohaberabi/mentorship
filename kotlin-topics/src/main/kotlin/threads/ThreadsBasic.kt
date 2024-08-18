package org.example.threads


private class MyThread : Thread() {
    override fun run() {
        Thread.sleep(3000)
        println("Iam Running from MyThread")
    }
}

private val runnable = Runnable {
    println("Iam Runnable from custom runnable")
}

private val thread = Thread(runnable)
private val lambdaThread = Thread {
    println("iam thread created using lambda")
}

fun main() {
    val myThread = MyThread()
    println("MyThread ->${myThread.state}")
    myThread.start()
    println("MyThread ->${myThread.state}")
    println("thread->${thread.state}")
    thread.start()
    println("thread->${thread.state}")
    println(lambdaThread.state)
    println("lambdaThread->${lambdaThread.state}")
    lambdaThread.start()
    println("MyThread ->${myThread.state}")
    println("lambdaThread->${lambdaThread.state}")
    println("thread->${thread.state}")

}