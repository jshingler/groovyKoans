package koans

/**
* Groovy Truth
* 
* Instructions: Replace __ with either a true or false.
*
* For more information, See:
* - http://groovy.codehaus.org/Groovy+Truth
*
*/
import spock.lang.*

@Stepwise
class TruthKoan extends Koan {
    public static ZERO = 0
    public static NON_ZERO = 3
    public static EMPTY_STRING = ""
    public static NEGATIVE_NUMBER = -1

    // Boolean Expressions
    
    def "01 - is true, true"() {
    	expect:
            assertTruth __, true
    }
    
    def "02 - is false, false"() {
    	expect:
            assertTruth __, false
    }

    // Objects
    
    def "03 - is null, true"() {
    	expect:
            assertTruth __, null
    }

    def "04 - is an object, true"() {
    	expect:
            assertTruth __, new Object()
    }

    // Numbers
        
    def "05 - is 0, true"() {
    	expect:
            assertTruth __, ZERO
    }
    
    def "06 - is Non Zero, True"() {
    	expect:
            assertTruth __, NON_ZERO
    }
    
    def "07 - is a negative number, true"() {
    	expect:
            assertTruth __, NEGATIVE_NUMBER
    }


    // Strings
    
    def "08 - is an empty string, true"() {
    	expect:
            assertTruth __, EMPTY_STRING
    }
    
    def "09 - is a string, true"() {
    	expect:
            assertTruth __, "Groovy is cool!!!"
    }
    
    // Collections
    
    def "10 - is an empty collection, true"() {
    	expect:
            assertTruth __, []
    }
    
    def "11 - is a collection with items, true"() {
    	expect:
            assertTruth __, [1,2,3] 
    }
    
    def "12 - is an iterator on an empty collection, true"() {
    	expect:
            assertTruth __, [].iterator()
    }
    
    def "13 - is an iterator on non-empty collection true"() {
    	expect:
            assertTruth __, [1,2,3].iterator()
    }
    
    // Maps
    
    def "14 - is an empty map, true"() {
    	expect:
            assertTruth __, [:]
    }
    
    def "15 - is a map with items, true"() {
    	expect:
            assertTruth __, ['one':1]
    }
    
    // Matchers
    
    def "16 - is an unMatched Matcher, true"() {
    	expect:
            assertTruth __, 'Hello Groovy' =~ /World/
    }
    
    def "17 - is a matched Matcher, true"() {
    	expect:
            assertTruth __, 'Hello World' =~ /World/
    }



    def assertTruth(expected, actual) {
        if(actual == null) {
            expected == false
        } else {
            expected == actual.asBoolean()
        }
    }
}  