package koans
/*
* Groovy Operator Overloading
*
* Instructions: Replace __ with your answer.
*
* For more information, See:
* - http://groovy.codehaus.org/Operator+Overloading
* 
*/
import spock.lang.*

@Stepwise
class OperatorOverloadingKoan extends Koan {
   def holder = new Holder()
        
    def "01 - plus Operator"() {
        when:
            holder.value = 1
            holder + 1
        then:
            __ == holder.value
    }
    
    def "02 - minus Operator"() {
        when:
            holder.value = 1
            holder - 1

        then:
            __ == holder.value
    }
    
    def "03 - multiply Operator"() {
        when:
            holder.value = 2
            holder * 3

        then:
            __ == holder.value
    }
    
    def "04 - power Operator"() {
        when:
            holder.value = 2
            holder ** 3

        then:
            __ == holder.value
    }
    
    def "05 - div Operator"() {
        when:
            holder.value = 6
            holder / 3

        then:
            __ == holder.value
    }
    
    def "06 - mod Operator"() {
        when:
            holder.value = 5
            holder % 2
        then:
            __ == holder.value
    }
    
    def "07 - or Operator"() {
        when:
            holder.value = false
            holder | true

        then:
            __ == holder.value
    }
    
    def "08 - and Operator"() {
        when:
            holder.value = false
            holder & true

        then:
            __ == holder.value
    }
    
    def "09 - xor Operator"() {
        when:
            holder.value = 1
            holder ^ 1

        then:
            __ == holder.value
    }
    
    def "10 - next Operator Prefix"() {
        when:
            holder.value = 1
            ++holder

        then:
            __ == holder
    }
    
    def "11 - next Operator Postfix"() {
        when:
            holder.value = 1
            holder++

        then:
            __ == holder
    }
    
    def "12 - previous Operator Prefix"() {
        when:
            holder.value = 1
            --holder

        then:
            __ == holder
    }
    
    def "13 - previous Operator Postfix"() {
        when:
            holder.value = 1
            holder--

        then:
            __ == holder
    }
    
    def "14 - getAt Operator"() {
        when:
            holder.value = ["no","yes"]

        then:
            __ == holder[1]
    }
    
    def "15 - putAt Operator"() {
        when:
            holder.value = ["abc", "def"]
            holder[1] = 123

        then:
            ___ == holder[1]
    }
    
    def "16 - leftShift Operator"() {
        when: 
            holder.value = "left"
            holder << "Shift"

        then:
            __ == holder.value
    }
    
    def "17 - right Operator"() {
        when:
            holder.value = "rightShift"
            holder >> "Shift"

        then:
            __ == holder.value
    }
    
    def "18 - bitwise Negative Operator"() {
        when:
            holder.value = 1
            ~holder

        then:
            __ == holder.value
    }
    
    def "19 - positive Operator"() {
        when:
            holder.value = -1
            (+holder)

        then:
            __ == holder.value
    }
    
    def "20 - negative Operator"() {
        when:
            holder.value = 1
            -holder

        then:
            __ == holder.value
    }
    def "21 - equals Operator"() {
        when:
            holder.value = 1

        then:
            __ == holder == 1
    }
    
    def "22 = notEquals Operator"() {
        when:
            holder.value = 1

        then:
            __ == holder != 1
    }
    
    def "23 - compareTo Operator"() {
        when:
            holder.value = 1
            def holder2 = new Holder(value:1)

        then:
            __ == holder <=> holder2
    }
    
    def "24 - greaterThan Operator"() {
        when:
            holder.value = 2
            def holder2 = new Holder(value:1)

        then:
            __ == holder > holder2
    }
    
    def "25 - greaterThanEqualTo Operator"() {
        when:
            holder.value = 1
            def holder2 = new Holder(value:1)

        then:
            __ == holder >= holder2
    }
    
    def "26 - lessThan Operator"() {
        when:
            holder.value = 2
            def holder2 = new Holder(value:1)

        then:
            __ == holder < holder2
    }

    def "27 - lessThanEqualTo Operator"() {
        when:
            holder.value = 1
            def holder2 = new Holder(value:1)

        then:
            __ == holder <= holder2
    }
}

class Holder implements Comparable {
        def value
        /*
            Operator         Method
            a + b         a.plus(b)
            a - b         a.minus(b)
            a * b         a.multiply(b)
            a ** b         a.power(b)
            a / b         a.div(b)
            a % b         a.mod(b)
            a | b         a.or(b)
            a & b         a.and(b)
            a ^ b         a.xor(b)
            a++ or ++a         a.next()
            a-- or --a         a.previous()
            a[b]         a.getAt(b)
            a[b] = c         a.putAt(b, c)
            a << b         a.leftShift(b)
            a >> b         a.rightShift(b)
            switch(a) { case(b) : }         b.isCase(a)
            ~a         a.bitwiseNegate()
            -a         a.negative()
            +a         a.positive()
         */
        
        def plus(x) { value = value + x }
        def minus(x) { value = value - x }
        def multiply(x) { value = value * x}
        def power(x) { value = value  **  x }
        def div(x) { value = value / x }
        def mod(x) { value = value % x }
        def or(x) { value = value | x }
        def and(x) { value = value & x }
        def xor(x) {value = value ^ x }
        def next() { ++value }
        def previous() { --value }
        def getAt(x) { value[x] }
        def putAt(x,y) { value[x] = y}
        def leftShift(x) { value = value << x }
        def rightShift(x) { value = value.replace(x,"")  }
        def isCase(x) {"switch(${value}) { case(${x}) : }"}
        def bitwiseNegate() {value = -(~value) }
        def positive() { value = value < 0 ? -1 * value : value }
        def negative() { value = value > 0 ? -1 * value : value }
        
        def boolean equals(x) { value.equals(x) }
        def int compareTo(x) { value.compareTo(x.value) }

        
        
}