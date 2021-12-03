package com.example.swip.service.SecondChapter;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyCompiler {
    public GroovyCompiler() {
    }

    public String getAnswer2_1(String userData){
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);

        return String.valueOf(shell.evaluate("System.out.println(\"Привет вот данные\" + userData);"));
    }

    public static void main(String[] args) {
        /*Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);

        shell.evaluate("public class FirstSample\n" +
                "{\n" +
                "   public static void main(String[] args)\n" +
                "   {\n" +
                "      System.out.println(\"We wid!'\");\n" +
                "   \n" +
                "}");*/
    }
}
