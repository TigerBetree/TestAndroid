package com.tiger.test.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.tiger.test.R

class TodoAdapter(val context: FragmentActivity?,
                  val todoList: ArrayList<Todo>,
                  val clickListener: TodoItemClickListener) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    interface TodoItemClickListener {
        fun onClick(caller: View, todo: Todo)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        lateinit var todoTitle: TextView
        lateinit var todoContext: TextView

        init {
            todoTitle = view.findViewById(R.id.todo_item_todo_title)
            todoContext = view.findViewById(R.id.todo_item_todo_content)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_todo_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todoList.get(position)

        holder.todoTitle.setText(todo.title)
        holder.todoContext.setText(todo.content)
        holder.itemView.setOnClickListener {
            clickListener.onClick(holder.itemView, todo)
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}
