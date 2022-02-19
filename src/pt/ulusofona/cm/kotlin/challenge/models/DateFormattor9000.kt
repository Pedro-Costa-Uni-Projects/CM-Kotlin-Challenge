package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*


class DateFormattor9000 {
    //Nota para professor: horrivel eu sei mas já perdi muitas horas só na data
    fun formattor(toConvert: Date): String {
        var day = toConvert.date
        var day2 = day.toString()
        if(day2.length == 1) {
            day2 = "0$day2"
        }

        var month = toConvert.month + 1
        var month2 = month.toString()
        if(month2.length == 1) {
            month2 = "0$month2"
        }

        var year = toConvert.year + 1900
        var year2 = year.toString()

        var dateToString = "$day2-$month2-$year2"
        return (dateToString)
    }

    fun dateSubtractor(birthDate : Date) : Int{
        var birthDateLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        var curentDate = LocalDate.now()
        return Period.between(birthDateLocalDate, curentDate).years
    }
}