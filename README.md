# Kotlin Demo CLI for Exploratory Data Analysis

This is a Kotlin Version of the EDA CLI build in Rust during
the [Coursera Specialization in Rust](https://www.coursera.org/learn/data-engineering-rust)
(see
implementation [here](https://github.com/amasotti/duke-rust-specialization-2/tree/main/week3/4-eda-polars-cli/eda_polars_cli))

## Tooling & Libraries
Rust was here replaced by Kotlin, and the Polars library was replaced
by [Kotlin Dataframe](https://github.com/Kotlin/dataframe) library.
For parsing the CLI arguments, [Clikt](https://github.com/ajalt/clikt) was used instead
of [Clap](https://crates.io/crates/clap).

[detekt](https://detekt.dev) is the static code analysis tool used in this project.

## Build

To build the project, run the following command:

```shell
./gradlew build
```

## Run

There are two ways at least to run the project:

- With gradle

```shell
./gradlew run --args="<command> <args>"
```

- With the generated binary

```shell
./gradlew installDist # to generate the binary

./build/install/eda-cli/bin/eda-cli <command> <args>
```

### Available Commands

#### Print 

Prints the first `n` rows of the dataframe.

```shell
./gradlew run --args="print --rows <n> --path <path to csv file>" # default 10
```
or 
    
```shell
./build/install/eda-cli/bin/eda-cli print --rows <n> --path <path to csv file> # default 10
```
Both options for running the CLI are available for the other commands, but they will 
not be repeated.

#### Describe

Prints the summary statistics of the dataframe.

```shell
./gradlew run --args="describe --path <path to csv file>"
```

#### Schema

Prints the schema of the dataframe.

```shell
./gradlew run --args="schema --path <path to csv file>"
```

#### Shape

Prints the size of the dataframe.

```shell
./gradlew run --args="shape --path <path to csv file>"
```

#### Sort

Sorts the dataframe by the given year.

```shell
./gradlew run --args="sort --path <path-to-csv> --year <year-column> --rows <number-of-rows> --order <true|false>"
```



