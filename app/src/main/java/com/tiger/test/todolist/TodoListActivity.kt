package com.tiger.test.todolist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tiger.test.R
import java.util.*

class TodoListActivity : AppCompatActivity() {

    var fab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todolist)

        // 测试数据
        var todo: Todo = Todo()
        todo.id = UUID.randomUUID().toString()
        todo.title = "测试-title"
        todo.content = "测试-content"
        TodoList.get().addTodo(todo)

        fab = findViewById<FloatingActionButton>(R.id.fab)
        fab?.setOnClickListener { _ ->

            val todoEditFragment = TodoEditFragment()

            supportFragmentManager.beginTransaction()
                    .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                    .addToBackStack(todoEditFragment.javaClass.simpleName)
                    .commit()

            hideFab()
        }

        val fragment = TodosFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .replace(R.id.content_main, fragment, fragment::class.java.simpleName)
                .commit()

        supportFragmentManager.addOnBackStackChangedListener {
            val backStackCount = supportFragmentManager.backStackEntryCount
            if (backStackCount == 0) {
                showFab()
            }
        }
    }

    fun hideFab() {
        fab?.visibility = View.GONE
    }

    fun showFab() {
        fab?.visibility = View.VISIBLE
    }
}