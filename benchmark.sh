#!/bin/bash

# Build package
mvn package

JAR=target/java-ios-1.0-SNAPSHOT.jar
FILE=/tmp/file.bin
OUT=benchmark.txt
SIZE=1048576

date >$OUT
java -jar $JAR $FILE -i TEXT write -s $SIZE >>$OUT
du -hb $FILE >>benchmark.txt
java -jar $JAR $FILE -i TEXT read >>$OUT
java -jar $JAR $FILE -i BUFFERED_TEXT write -s $SIZE >>$OUT
du -hb $FILE >>$OUT
java -jar $JAR $FILE -i BUFFERED_TEXT read >>$OUT
java -jar $JAR $FILE -i BINARY write -s $SIZE >>$OUT
du -hb $FILE >>$OUT
java -jar $JAR $FILE -i BINARY read >>$OUT
java -jar $JAR $FILE -i BUFFERED_BINARY write -s $SIZE >>$OUT
du -hb $FILE >>$OUT
java -jar $JAR $FILE -i BUFFERED_BINARY read >>$OUT
