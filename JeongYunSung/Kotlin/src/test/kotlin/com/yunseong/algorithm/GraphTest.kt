package com.yunseong.algorithm

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

@ParameterizedTest
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ArgumentsSource(GraphArgumentProvider::class)
annotation class GraphTest(

    val intArray: IntArray = [],
    val stringArray: Array<String> = []
)
