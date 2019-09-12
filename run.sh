#!/bin/sh
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.launcher.airport.Simulator ressources/scenario.txt
rm -Rf ./**/*.class
