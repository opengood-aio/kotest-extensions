package io.opengood.extensions.kotest.matcher

import io.kotest.core.spec.style.FunSpec

class MapTest : FunSpec({

    test("list of map of generic types shouldBeEqualIgnoringKeys extension method asserts maps are equal with ignored keys") {
        val expected = listOf(
            mapOf(
                "foo" to "bar"
            ),
            mapOf(
                "foo" to "baz"
            )
        )

        val items = listOf(
            mapOf(
                "none" to "none",
                "foo" to "bar"
            ),
            mapOf(
                "none" to "none",
                "foo" to "baz"
            )
        )

        items.shouldBeEqualIgnoringKeys(expected, "none")
    }

    test("map shouldBeMapEntry extension method asserts map entries are equal") {
        fun makeEntry(key: String, value: String) = object : Map.Entry<String, String> {
            override val key: String = key
            override val value: String = value
        }

        val expected = makeEntry("foo", "bar")

        makeEntry("foo", "bar") shouldBeMapEntry expected
    }
})
