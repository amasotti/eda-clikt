package edaclikt

import com.github.ajalt.clikt.core.subcommands
import edaclikt.commands.*


const val CSV_FILE = "src/main/resources/demo.csv"




fun main(args: Array<String>) = CLI()
    .subcommands(
        Print(), Describe(), Schema(), Shape(), Sort()
    )
    .main(args)
