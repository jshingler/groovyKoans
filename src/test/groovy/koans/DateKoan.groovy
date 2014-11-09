package koans

/*
* Groovy Dates
*
* Instructions: Replace __ with your answer.
*
* For more information, See:
* - http://groovy.codehaus.org/JN0545-Dates
* - http://groovy.codehaus.org/groovy-jdk/java/util/Date.html
* - http://download.oracle.com/javase/6/docs/api/java/util/Date.html 
* - http://groovy.codehaus.org/groovy-jdk/java/util/Calendar.html
* - http://download.oracle.com/javase/6/docs/api/java/util/Calendar.html
*
*/

import spock.lang.*

@spock.lang.Stepwise
class DateKoan extends Koan {

    // Creating Dates
    def "01 - create a date from a string"() {
        when:
            def date = new Date().parse('yyyy/MM/dd', '2001/09/11')


        then:
            __ == date.class.name
            __ == date.year
            __ == date.month
            __ == date.date
            __ == date.hours
            __ == date.minutes
    }
    
    def "02 - create a date using constuctor"() {
        when:
            // Java Constructor
            def date = new Date(101,8,11)

            // Groovy Named Parameters
            def date2 = new Date(year: 101, month: SEPTEMBER, date: 11, hours:0, minutes: 0, seconds: 0)

        then:
            __ == date.class.name
            __ == date.year
            __ == date.month
            __ == date.date
            __ == date.hours
            __ == date.minutes

            __ == date2.class.name
            __ == date2.year
            __ == date2.month
            __ == date2.date
            __ == date2.hours
            __ == date2.minutes
    }
    
    def "03 - create a date from a calandar"() {
        when:
            def cal = Calendar.instance
            cal.set(year: 2001, month: SEPTEMBER, date: 11, hourOfDay: 0, minute: 0, second: 0)
            def date = cal.time

        then:
            __ == cal.class.name
            __ == cal.time.class.name
            
            __ == date.year
            __ == date.month
            __ == date.date
            __ == date.hours
            __ == date.minutes
    }
    
    def "04 - setting date values"() {
        when:
            def date = new Date()
            date.set(hourOfDay: 0, minute: 0, second: 0, year: 2001, month: SEPTEMBER, date: 11)

            def date2 = new Date()
            date2.year = 101
            date2.month = SEPTEMBER
            date2.date = 11
            date2.hours = 0
            date2.minutes = 0
            date2.seconds = 0

        then:
            __ == date.class.name
            __ == date.year
            __ == date.month
            __ == date.date
            __ == date.hours
            __ == date.minutes
            
            __ == date2.year
            __ == date2.month
            __ == date2.date
            __ == date2.hours
            __ == date2.minutes
    }
    
    def "05 - clearing time portion of date"() {
        when:
            def date = new Date()
            date.clearTime()

        then:
            __ == date.hours
            __ == date.minutes
            __ == date.seconds
    }
    
    // accessors
    def "06 - getting date values using map notation"() {
        when:
            def date = new Date(year: 101, month: SEPTEMBER, date: 11, hours:0, minutes: 0, seconds: 0)

        then:
            __ == date[YEAR]
            __ == date[MONTH]
            __ == date[DATE]
            __ == date[HOUR]
            __ == date[MINUTE]
            __ == date[SECOND]
    }
    
    def "07 - getting date values using field notation"() {
        when:
            def date = new Date(year: 101, month: SEPTEMBER, date: 11, hours:0, minutes: 0, seconds: 0)

        then:
            __ == date.year
            __ == date.month
            __ == date.date
            __ == date.hours
            __ == date.minutes
            __ == date.seconds
    }
    
    def "08 - getting date string values using getters"() {
        when:
            def date = new Date(year: 41, month: DECEMBER, date: 07, hours:7, minutes: 55, seconds: 0)

        then:
            __ == date.dateString        
            __ == date.timeString 
            __ == date.dateTimeString
    }
    
    
    // Date Math
    def "09 - date math"() {
        when:
            def date = new Date(year: 101, month: SEPTEMBER, date: 11, hours:0, minutes: 0, seconds: 0)
            def datePlusOne = date + 1
            def dateMinusOne = date - 1

            def dateIncrement = ++date

            def dateDecrement = --date

        then:
            __ == datePlusOne.year
            __ == datePlusOne.month
            __ == datePlusOne.date
            __ == datePlusOne.hours
            __ == datePlusOne.minutes
            __ == datePlusOne.seconds
            
            __ == dateMinusOne.year
            __ == dateMinusOne.month
            __ == dateMinusOne.date
            __ == dateMinusOne.hours
            __ == dateMinusOne.minutes
            __ == dateMinusOne.seconds
            
            __ == dateIncrement.year
            __ == dateIncrement.month
            __ == dateIncrement.date
            __ == dateIncrement.hours
            __ == dateIncrement.minutes
            __ == dateIncrement.seconds
            
            __ == dateDecrement.year
            __ == dateDecrement.month
            __ == dateDecrement.date
            __ == dateDecrement.hours
            __ == dateDecrement.minutes
            __ == dateDecrement.seconds
    }
    
    // Compare Dates
    def "10 - comparing dates"() {
        when:
            def date = new Date(year: 101, month: SEPTEMBER, date: 11, hours:0, minutes: 0, seconds: 0)
            def datePlusOne = date + 1
            def dateMinusOne = date - 1

        then:
            __.after(date)
            __.before(date)
            __.compareTo(date) > 0
            __.compareTo(date) < 0
            __.compareTo(date) == 0
    }
}  