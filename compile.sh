#!/bin/sh
# shellcheck disable=SC2046
javac -d bin $(find ./src/ -type f -name '*.java')