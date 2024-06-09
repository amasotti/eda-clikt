
alias r := run
alias c := clean
alias b := build

build:
    ./gradlew build installDist

clean:
    ./gradlew clean

run ARGS:
    ./gradlew run --args="{{ARGS}}"

compile:
    ./gradlew installDist

run-cli ARGS:
     ./build/install/eda-clikt/bin/eda-clikt {{ARGS}}
