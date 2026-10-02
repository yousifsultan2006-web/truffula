# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
File decides what files to print, and if colored output should be used. The file also has the root directory that begins the printing of the tree.
file uses flags to control if output is colored, and if hidden files should be shown. output is colored by default
the path is mandatory as it is the direct or relative path to the direcotry in which the data that will be printed is located. 
-h is the flag that sets show hidden files to false 
-nc turns off color. 
order of flags is irrelevant, path must be the last argument

## ConsoleColor.java
enum is a special type declaration. it defines the available console text colors that can be used. Each enum value represents a specific color using ANSI escape code. ANSI escape code is code that controls what color console text is printed with.
the ConsoleColor file uses this enum in creating a code final string value named code, which is used to construct a ConsoleColor. 
the file also includes a getCode method that gets the ANSI code associated with the color

## ColorPrinter.java / ColorPrinterTest.java
This class is a utility class for printing  colored text into printStream with the ANSI escape codes in ConsoleColor
ColorPrinter sets the text to a specific color, and prints that text in that color to the specified printStream. the color can be reset after each print or kept depending on the parameters. 
Usage example would have you constructing a ColorPrinter, setting it to a specific printStream, using the setCurrentColor method to set it to a color from the ConsoleColor enum, and then printing it using the println method on the constructed ColorPrinter. 
The file includes the setCurrentColor method that sets the current printing color, getCurrentColor method which returns the current printing color, and println which prints a new message in a new line. the color is set to default when this method is called. another println method is defined, this one gives you the option to reset the color if you set the parameter to false. the initial println method also take a parameter of true or false for the reset, but does not mention it being optional. 
print is a method that prints a new message without appending a new line. it also has 2 method creations, with the same reset and optional reset as println. 
there are 2 constructors that create ColorPrinters. one which only takes one paramter which is the printStream, if this is called, the defualt color is white. The other ColorPrinter takes a printStream and an initial ConsoleColor


## TruffulaOptions.java / TruffulaOptionsTest.java

## TruffulaPrinter.java / TruffulaPrinterTest.java

## AlphabeticalFileSorter.java