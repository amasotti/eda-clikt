package edaclikt

import com.github.ajalt.clikt.core.subcommands
import edaclikt.commands.Describe
import edaclikt.commands.Print


const val CSV_FILE = "src/main/resources/demo.csv"




fun main(args: Array<String>) = CLI()
    .subcommands(Print(), Describe())
    .main(args)
