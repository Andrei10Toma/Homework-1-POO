.PHONY: all build run

all: build run

build: Vehicle Map Main

Vehicle:
	@javac -g -sourcepath src -d . src/Vehicle/*.java

Map:
	@javac -g -sourcepath src -d . src/Map/*.java

Main:
	@javac -g -sourcepath src -d . src/Test.java

run:
	@java Test
