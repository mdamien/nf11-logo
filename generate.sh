#!/bin/bash

#export CLASSPATH="lib/antlr-4.5-complete.jar:$CLASSPATH"
#java org.antlr.v4.Tool -visitor -o src/logoparsing  grammar/Logo.g4

#env CLASSPATH="lib/antlr-4.5-complete.jar:$CLASSPATH" java org.antlr.v4.Tool -visitor -o src/logoparsing  grammar/Logo.g4

export CLASSPATH="lib/antlr-4.5-complete.jar:$CLASSPATH"
java org.antlr.v4.Tool -visitor -o src/logoparsing Logo.g4
