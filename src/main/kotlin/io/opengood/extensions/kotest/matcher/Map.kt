package io.opengood.extensions.kotest

import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.maps.shouldContainKey
import io.kotest.matchers.shouldBe
import java.util.UUID

internal fun <K : Any, V : Any> List<Map<K, V>>.shouldBeEqualIgnoringKeys(
    expected: List<Map<K, V>>,
    vararg keys: K
) {
    this.shouldNotBeEmpty()
    this.size shouldBe expected.size

    expected.forEachIndexed { i, expectedMap ->
        val actualMap = this[i]
        expectedMap.forEach { (expectedKey, expectedValue) ->
            if (!keys.contains(expectedKey)) {
                actualMap.shouldContainKey(expectedKey)
                actualMap[expectedKey] shouldBe expectedValue
            }
        }
    }
}

internal infix fun <K : Any, V : Any> Map.Entry<K, V>.shouldBeMapEntry(
    expected: Map.Entry<K, V>
) {
    key shouldBe expected.key
    value shouldBe expected.value
}

internal val toUuid: (Any) -> UUID = {
    UUID.fromString(it.toString())
}
