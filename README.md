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
