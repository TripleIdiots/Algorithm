package com.yunseong.algorithm.tree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

@ParameterizedTest
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(TreeArgumentProvider::class)
annotation class TreeTest(

    val intArray: IntArray = [],
    val stringArray: Array<String> = []
)
