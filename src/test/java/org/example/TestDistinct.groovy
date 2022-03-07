package org.example

import spock.lang.Specification

class TestDistinct extends Specification {

    def "should return distinct string"() {
        given:
        def distinct = new Distinct()
        expect:
        result == distinct.removeDuplicates(string, count)
        where:
        result | string       | count
        "d"    | "aabcccbbad" | 3
        "aa"    | "deeedbbcccbdaa" | 3
    }
}
