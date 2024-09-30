#!/bin/bash

# Build package
if ./mvnw package; then
	exit 1
fi

JAR=target/java-ios-1.0-SNAPSHOT.jar
FILE=/tmp/file.bin
OUT=benchmark.txt

date >$OUT
java -jar $JAR $FILE -i TEXT write -s 1024 >>$OUT
du -hb $FILE >>benchmark.txt
java -jar $JAR $FILE -i TEXT read >>$OUT
java -jar $JAR $FILE -i BUFFERED_TEXT write -s 1024 >>$OUT
du -hb $FILE >>$OUT
java -jar $JAR $FILE -i BUFFERED_TEXT read >>$OUT
java -jar $JAR $FILE -i BINARY write -s 1024 >>$OUT
du -hb $FILE >>$OUT
java -jar $JAR $FILE -i BINARY read >>$OUT
java -jar $JAR $FILE -i BUFFERED_BINARY write -s 1024 >>$OUT
du -hb $FILE >>$OUT
java -jar $JAR $FILE -i BUFFERED_BINARY read >>$OUT
