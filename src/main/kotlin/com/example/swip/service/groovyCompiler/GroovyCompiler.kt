package com.example.swip.service.groovyCompiler

import groovy.lang.GroovyShell
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.io.PrintStream

@Service
class GroovyCompiler {
    fun execute(codeSTR: String): String {
        val binding = groovy.lang.Binding()
        val shell = GroovyShell(binding)

        //перенаправим потоки вывода
        val buffer = ByteArrayOutputStream()
        val saveSystemOut = System.out
        System.setOut(PrintStream(buffer))

        try {
            shell.evaluate(codeSTR)
        } catch (e: Error) {
            System.setOut(saveSystemOut)
            return "Incorrect answer"
        } catch (e: Exception) {
            System.setOut(saveSystemOut)
            return "Incorrect answer"
        }

        //вернем все на место
        System.setOut(saveSystemOut)

        val compiledValue = buffer.toString()
        return compiledValue.subSequence(0, compiledValue.length - 2).toString()
    }
}