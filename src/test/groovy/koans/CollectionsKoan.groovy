package koans

/**
 * Groovy Collections
 * 
 * Instructions: Replace __ with your answer.
 *
 * For more information, see:
 * - http://groovy.codehaus.org/JN1015-Collections
 * - http://groovy.codehaus.org/Collections
 * - http://groovy.codehaus.org/groovy-jdk/java/util/Collection.html
 * - http://groovy.codehaus.org/groovy-jdk/java/util/List.html
 * - http://groovy.codehaus.org/groovy-jdk/java/util/Set.html
 */

import spock.lang.*
import spock.lang.Stepwise

@spock.lang.Stepwise
class CollectionsKoan extends Koan {

    def "01 - creating a Collection"() {
        when:
            def list = []
            List list2 = [];

        then:
            __ == list.size
            __ == list2.size
    }

    def "02 - Collection is an instance of ?? interface"() {
        expect:
            [] instanceof Object
    }
    
    def "03 - collection Type name"() {
        expect:
            __ == [].class.name
    }
    
    def "04 - initializing Collection"() {
        when:
            def list = ['a', 1, 'a', 'a', 2.5, 2.5f, 2.5d, 'hello', 7g, null, 9 as byte, ]

        then:
            __ == list.size // "collections hold multiple types, duplicates and can contain an extra comma"
    }
    
    def "05 - Collection Truth"() {
        expect:
            assertTruth __ ,[]
            assertTruth __, ['a']
    }

    def "06 - accessing Collections"() {
        when:
            def list = ['a', 'b', 'c', 'd', 'e'];
            
        then:
            __ == list.get(2)  //, 'get method'
            __ == list[3]      //, 'index access'
            __ == list.first() //, 'first method'
            __ == list.last()  //, 'last method'
            __ == list.head()  //, 'head method'
            __ == list.tail()  //, 'tail method'
    }
    
    def "07 - appending Collections"() {
        when:
            def list = ['a'];
            
            list.add('b')
            list.addAll(['c','d'])
            list.push('e')
            list << 'f'

        then:
            [__] == list       //, "add, push and << operator"
            
            [__] == list + 'g' //, "+ operator"

    }

    def "08 - insert into Collections"() {
        when:
            def list = ['a','b','c'];
            
            list.add(1,'d')

        then:
            [__] == list  //, "add with index"
            
            list.addAll(2, ['e','f'])
            [__] == list  //, "add all with index"
    }
    
    def "09 - updating Collections"() {
        when:
            def list = ['a','b','c'];
            
            list[0] = 'e'
            ['e','b','c'] == list   //, 'subscript index update'
            
            'c' == list.set(2, 'f') //, 'element replacement'

        then:
            [__] == list
    }
            
    def "10 - chaining Append"() {
        when:
            def list = ['a']
            
            list << 'g' << 'h'

        then:
            [__] == list
    }
    
    def "11 - appending Lists"() {
        when:
            def list = ['a']
            
            list << ['i','j']

        then:
            [__] == list
    }

    def "12 - flattenting Lists"() {
        when:
            def list = [['a',['b','b']], ['c','d'], 'e']
            
        then:
            [__] == list.flatten()
    }

    
    def "13 - accessing beyond Collection bounds"() {
        when:
            int beyondBounds = 5
            def list = ['a', 'b','c']
            
        then:
            __ == list[beyondBounds] //, "accessing element beyond current size"
    }
            
    def "13.5 - assignment beyond Collection bounds"() {
        when:
            int beyondBounds = 5
            def list = ['a', 'b','c']
            list[beyondBounds] = 'j'
        then:
            [__] == list             //, "setting element beyond current size"
    }

    def "14 - accessing with negative index"() {
        when:
            def list = ['a', 'b', 'c', 'd', 'e']
            
        then:
            __ == list[-1] //, "-1 indices"
            __ == list[-2] //, "-2 indices"
    }
    
    def "15 - slicing Collection"() {
        when:
            def list = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']

        then:
            [__] == list[1..3]       //, "range slicing"
            [__] == list[0,2,4]      //, "index slicing"        
            [__] == list[0,2,4,5..8] //, "combination of index and range slicing"
    }
    
    def "16 - accessing Collection by each closure"() {
        when:
            def items = ""
            
            ['a', 'b', 'c'].each{ items += "Item: $it \n" }

        then:
            __ == items
    }
    
    def "17 - accessing Collection by each with index"() {
        when:
            def items = ""
    
            ['a', 'b', 'c'].eachWithIndex{ it, i -> items += "$i: $it\n" }

        then:    
            __ == items
    }

    def assertTruth(expected, actual) {
        if(actual == null) {
            expected == false
        } else {
            expected == actual.asBoolean()
        }
    }
}  