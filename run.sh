find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java com.launcher.airport.Simulator  
