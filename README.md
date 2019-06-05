# Hash
##  Introduction 
This is my own String [Hashing algorithms](https://en.wikipedia.org/wiki/Hash_function) that use additive and folding hash algorithms. Moreover, due to the algorithms need test so [JUnit 5](https://junit.org/junit5/) was also used to test the 2 algorithms
##	Version: 
-	It is written by using IntelliJ IDEA Community Edition 2019.1.3 x64
-	JDK version 11
##	How to install:
If you use IntelliJ IDEA use new -> Project From Version Control -> Git and paste https://github.com/JimmyYouhei/Hash.git
##	How to use: 
-	Using the Main class to run any custom command 
-	TheStringHash class is fully written with method: 
    - getStringValue() : return the current String 
    -	setStringValue(String string): set the new String Value 
    -	additiveHash(): return an int from the additive Hashing algorithm
    -	foldingHash(): return an int from the folding hashing algorithm
-	A test class that used Junit 5 to test for the result of the 2 algorithms above  
V.	Note:
-	Due to the class is written purely for learning purpose so very little Exception handle is expected 
VI.	License 
[MIT License](https://github.com/JimmyYouhei/Hash/blob/master/LICENSE)
