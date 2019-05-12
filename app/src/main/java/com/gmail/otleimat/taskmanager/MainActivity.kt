package com.gmail.otleimat.taskmanager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Task(val id: Int, val task: String, val finished: Boolean)
        val tasks = Klaxon().parseArray<Task>(assets.open("tasks.json"))
        tasks?.let {
            for (task in it){
                Log.d("id", task.id.toString())
                Log.d("task", task.task)
                Log.d("Finished", task.finished.toString())
            }
        }
    }
}
