package com.tiger.test.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.tiger.test.R

class TodosFragment : Fragment(), TodoAdapter.TodoItemClickListener {

    companion object {
        fun newInstance(): TodosFragment {
            return TodosFragment()
        }
    }

    lateinit var recyclerView: RecyclerView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_todos, container, false)
        recyclerView = view.findViewById(R.id.todos_recycler_view)
        return view
    }

    override fun onResume() {
        super.onResume()

        val adapter = TodoAdapter(activity, TodoList.get().getAll(), this)
        recyclerView.setAdapter(adapter)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClick(caller: View, todo: Todo) {
        (activity as TodoListActivity).hideFab()

        val todoEditFragment = TodoEditFragment.newInstance(todo.id)

        this.activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                .addToBackStack(todoEditFragment.javaClass.simpleName)
                .commit()
    }
}