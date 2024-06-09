package edaclikt.utils

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.io.readCSV


/**
 * Reads a CSV file and returns a DataFrame.
 *
 * @param path The path to the CSV file.
 * @return A DataFrame containing the data from the CSV file.
 */
fun readCSV(path: String): DataFrame<*> = DataFrame.readCSV(path)
