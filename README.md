# basic_security_algorithm
Dividing one file into few Files and sending separately to provide security information. Netbeans used as programming environment. Not tested yet with modern tools specialized in. 

# Problem:
To increase security your company implemented a new communication protocol for employees. Starting
from now, the encrypted file need to be divided into multiple files with mixed every lines and then sent using different
protocols.
# The process of dividing the encrypted file is as follows:
# 1. Read next line from the encrypted file.
# 2. Randomly choose the output file.
# 3. In a new line write the line number, then a space and the line read in step 1 to the output file.
# 4. If the encrypted file contains more lines go to step nr 1.

# As a developer you were asked to write a tool which will merge all files received back into a single file.

Input: a path to a folder with up to 100 plain text files. The total amount of lines from all input files is
from 0 to 214748363 and the maximum line length is 1000 characters.

Output: please do not write to the standard output, create a new out.txt file in the current working
directory instead.

# Example:
-------------------------------------------
# input1.txt
# 2 sssgggheeewww642
-------------------------------------------
# input2.txt
# 1 evftrghtgb
# 3 dfgdgfgt
-------------------------------------------
# output.txt
# 1 evftrghtgb
# 2 sssgggheeewww642
# 3 dfgdgfgt
-------------------------------------------
counting files in algorithm and scaling - input must be constructed properly
