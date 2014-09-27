package koans

/*
* Groovy Strings
*
* Instructions: Replace __ with your answer.
*
* For more information, See:
* - http://groovy.codehaus.org/Strings+and+GString
* - http://groovy.codehaus.org/JN1525-Strings
*
*/

import spock.lang.*
import spock.lang.Stepwise

@spock.lang.Stepwise
class StringKoan extends Koan {

    def "01 - what type is a double quoted string"() {
        expect:
            __ == "Any ole String".class.name
    }
        
    def "02 - what type is a single quoted string"() {
        expect:
            __ == 'A Single Quote String'.class.name
    }


    def "03 - what type is a slashy string"() {
        expect:
            __ == /A Slashy String/.class.name
    }

    def "04 - what type is a multi-line string"() {
        expect:
            __ == """A Triple Quote String""".class.name
    }

    def "05 - string interpolation"() {
        def answer = "c"

        expect:
            __ == "ab${answer}"
            __ == 'ab${answer}'
            __ == /ab${answer}/
    }


    def "06 - what type is an Interpolated String"() {
        def answer = "c"

        expect:
            __ == "ab${answer}".class.name
            __ == 'ab${answer}'.class.name
            __ == /ab${answer}/.class.name
    }
    
    def "07 - Multi-Line Strings"() {
        def myStr1 = "Stuff"
        def myStr2 = "More Stuff"
        def name = """${myStr1}
${myStr2}"""
        def name2 = """${myStr1} \
${myStr2}"""

        expect:
            __ == name
            __ == name2
    }
    
    def "08 - how are strings concatenated"() {
        def myStr1 = "ab"
        def myStr2 = "cd"

        expect:
            __ == myStr1 + " " + myStr2
            __ == (myStr1 << " " << myStr2).toString() // leftShift returns a StringBuffer
            __ == myStr1.plus(" ").plus(myStr2)
    }
    
    def "09 - are Strings Mutable"() {
        def myString = "abc"

        expect:
            "abc" == myString
            "cba" == myString.reverse()
            "abc" == myString
    }
    
    def "10 - is String Builder Mutable"(){
        def myStrBldr = new StringBuilder("abc")

        expect:
            __ == myStrBldr.toString()
            __ == myStrBldr.reverse().toString()
            __ == myStrBldr.toString()
    }
        
        
    def "11 - how to substring strings"() {
        expect:
            'abcdefg'[ 3 ] == __
            'abcdefg'.getAt( 3 ) == __ //equivalent method name
            'abcdefg'.charAt( 3 ) == __ //alternative method name
            'abcdefg'[ 3..5 ] == __
            'abcdefg'.getAt( 3..5 ) == __
            'abcdefg'[ 1, 3, 5, 6 ] == __
            'abcdefg'[ 1, 3..5 ] == __
            'abcdefg'[-5..-2] == __
            'abcdefg'.getAt( [ 1, 3..5 ] ) == __
    }
    
    def "12 - how to substring String Builder"() {
        def myStrBldr = new StringBuilder("abcd")

        expect:
            __ == myStrBldr[1..3]
            __ == myStrBldr.toString()
    }
    
    def "13 - hot to append to String Builder"() {
        when: 
        def myStrBldr = new StringBuilder("ab")
        myStrBldr.append "cd"

        then:
            __ == myStrBldr.toString()

            myStrBldr << "ef"
            __ == myStrBldr.toString()
    }
}  