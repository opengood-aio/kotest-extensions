package io.opengood.extensions.kotest.matcher

import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.shouldBe

fun <K : Any, V : Any> List<Map<K, V>>.shouldBeEqualIgnoringKeys(
    expected: List<Map<K, V>>,
    vararg keys: K
) {
    shouldNotBeEmpty()
    size shouldBe expected.size

    expected.forEachIndexed { i, expectedMap ->
        val actualMap = this[i]
        expectedMap.forEach { (key, value) ->
            if (!keys.contains(key)) {
                actualMap.shouldContain(key, value)
            }
        }
    }
}

infix fun <K : Any, V : Any> Map.Entry<K, V>.shouldBeMapEntry(
    expected: Map.Entry<K, V>
) {
    key shouldBe expected.key
    value shouldBe expected.value
}
