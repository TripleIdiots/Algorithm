package com.yunseong.algorithm.queue

class Queue<T>(
    initialValue: T? = null
) {

    private val list = mutableListOf<T>()

    init {
        initialValue?.let {
            list.add(it)
        }
    }

    fun enqueue(value: T) {
        list.add(value)
    }

    fun dequeue(): Result<T> {
        if (list.isEmpty()) {
            return Result.failure(Exception("Queue is empty"))
        }
        return Result.success(list.removeAt(0))
    }

    fun poll(): Result<T> {
        if (list.isEmpty()) {
            return Result.failure(Exception("Queue is empty"))
        }
        return Result.success(list[0])
    }

    fun hasValue(): Boolean {
        return list.isNotEmpty()
    }
}
