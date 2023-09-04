package com.tiger.test.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tiger.test.R
import java.util.*

class TodoEditFragment : Fragment() {

    var todo: Todo? = null
    var rootView: View? = null

    companion object {
        val TODO_ID_KEY: String = "todo_id_key"

        fun newInstance(id: String): TodoEditFragment {
            var args: Bundle = Bundle()
            args.putString(TODO_ID_KEY, id)

            var todoEditFragment: TodoEditFragment = newInstance()
            todoEditFragment.arguments = args
            return todoEditFragment
        }

        fun newInstance(): TodoEditFragment {
            return TodoEditFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(R.layout.fragment_edit_todo, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val todoTitle = rootView!!.findViewById<EditText>(R.id.et_title)
        val todoContent = rootView!!.findViewById<EditText>(R.id.et_content)
        val add = rootView!!.findViewById<Button>(R.id.button)

        if (arguments != null && requireArguments().containsKey(TODO_ID_KEY)) {
            val todoId = requireArguments().getString(TODO_ID_KEY)

            todo = todoId?.let { TodoList.get().getTodoById(it) }

            todoTitle.setText(todo?.title)
            todoContent.setText(todo?.content)
            add.setText(R.string.save)
        }

        add.setOnClickListener {
            createTodoFrom(todoTitle, todoContent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    /**
     *  新增待办事项，存入Realm数据库
     *
     *  @param title the title edit text.
     *  @param todoContent the content edit text.
     */
    private fun createTodoFrom(title: EditText, todoContent: EditText) {
        var t = Todo()
        t.id = todo?.id ?: UUID.randomUUID().toString()
        t.title = title.text.toString()
        t.content = todoContent.text.toString()

        if (todo == null) {
            TodoList.get().addTodo(t)
            Toast.makeText(activity, "添加成功", Toast.LENGTH_SHORT).show()
        } else {
            TodoList.get().updateTodo(t)
            Toast.makeText(activity, "编辑成功", Toast.LENGTH_SHORT).show()
        }

        requireActivity().supportFragmentManager.popBackStack()
    }
}