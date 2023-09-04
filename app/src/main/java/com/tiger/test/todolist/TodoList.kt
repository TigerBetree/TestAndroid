package com.tiger.test.todolist

class TodoList private constructor() {
    companion object {
        fun get(): TodoList {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = TodoList()
    }

    var sTodoList: ArrayList<Todo> = ArrayList()

    fun getAll(): ArrayList<Todo> {
        return sTodoList;
    }

    fun addTodo(todo: Todo) {
        sTodoList.add(todo)
    }

    fun updateTodo(newTodo: Todo) {
        var index: Int = 0
        for (i in sTodoList.indices) {
            if (sTodoList[i].id == newTodo.id) {
                index = i
                break
            }
        }
        sTodoList.removeAt(index)
        sTodoList.add(newTodo)
    }

    fun getTodoById(id: String): Todo? {
        for (todo in sTodoList) {
            if (todo.id == id) {
                return todo
            }
        }
        return null
    }
}