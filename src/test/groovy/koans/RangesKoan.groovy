package koans

/*
* Groovy Ranges
*
* Instructions: Replace __ with your answer.
*
* For more information, See:
* - http://groovy.codehaus.org/Collections  (See Ranges)
* - http://groovy.codehaus.org/api/groovy/lang/Range.html
*
*/

import spock.lang.*
import spock.lang.Stepwise

@spock.lang.Stepwise
class RangesKoan extends Koan {

    def "01 - creating a range"() {
        when:
            def range = 1..5

        then:
            __ instanceof Range
    }
    
    def "02 - is a range a list"() {
        when:
            def range = 1..5
    
        then:
            __ instanceof List
    }
    
    def "03 - getting the size of a range"() {
        when:
            def range = 1..5
        
        then:
            __ == range.size()
    }
    
    def "04 - accessing a range"() {
        when:
            def range = 1..5

        then:
            range.get(2) == __
            range[2] == __
    }
    
    def "05 - boundaries of a range"() {
        when:
            def range = 1..5
    
        then:
            range.from == __
            range.to == __
    }
    
    def "06 - creating non inclusive range"() {
        when:
            def range = 1..<5
    
        then:
            range.from == __
            range.to == __
    }
    
    def "07 - creating a range alphabet"() {
        when:
            def range = 'a'..'z'

        then:
            range instanceof Range
            range.from == __
            range[5] == __
            range.to == __
    }
}  