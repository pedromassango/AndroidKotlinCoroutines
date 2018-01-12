package com.pedromassango.kotlincoroutines


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = "Kotlin -> Coroutines" // A message to be show with Coroutines

        // Start coroutines Task
        setup(message)
    }

    private fun setup(message: String = "Massango") {

        val x = launch(UI) { // START coroutine

            tv_hello?.text = "" // Clear hold text

            message.forEach {
                var lastText = tv_hello?.text.toString()

                lastText += it

                tv_hello?.text = lastText // Pass the updated text on TextView

                delay(500) // Suspend the coroutine
            }
        }

        // Handle fab click
        fab?.setOnClickListener { setup() }
    }

}
