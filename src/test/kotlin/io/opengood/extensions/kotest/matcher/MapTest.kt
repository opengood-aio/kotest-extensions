package io.opengood.commons.kotlin.function

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MapTest : FunSpec({

    test("map of generic types makeEntry function returns map entry object") {
        val result = makeEntry("foo", "bar")

        result.key shouldBe "foo"
        result.value shouldBe "bar"
    }
})
