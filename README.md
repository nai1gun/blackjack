Blsckjack
=========

Text-based Blackjack game written in Java.

###System requirements
* MacOs X, Windows XP or later, Linux
* Java 7 or later

###How to launch application
Open command line in `target` directory then run command:

```sh
java -jar BlackJack-single.jar
```
###How to build from sources
First install [Maven] on your computer

Then open command line in project root and run command:

```sh
mvn package
```
Then executable file will appear in `target` directory

###License
MIT

###Author
[Alexander Korvyakov]

####Have a fun game!
---------------------------------

##### If you have issues with encoding on Windows
then run `chcp 850` command and then relaunch the game.

##### Known issues:
* Card suit symbols cannot be displayed on Windows command line. There are corresponding letters instead.
* Blink effect works only on MacOs X

[Maven]:http://maven.apache.org/
[Alexander Korvyakov]:http://korvyakov.com
