# Bee Champion

## Purpose
This program is a spelling bee competition where the player competes against AI opponents in a turn-based spelling game. Players must correctly spell randomly selected words to remain in the competition, and the last player standing wins.

## Group Members
- Winston Le
- Safiyy Muhammad

## Major Features
- **Competitive Spelling Bee:** Compete against AI players in a turn-based spelling bee.
- **AI Opponents:** Face AI players with varying spelling abilities and difficulty levels.
- **Elimination System:** Players who misspell a word are eliminated from the competition.
- **Progressive Difficulty:** Words become more challenging as the competition progresses.
- **Victory Condition:** Be the last player standing to win the spelling bee.

## Java Concepts Implemented
- **Classes and objects:** Classes and objects will represent the players, spelling words, and the spelling bee game. Each player will have attributes such as their name and elimination status, while the game class will manage the competition.
- **Exception handling:** Try/catch blocks will handle invalid input to prevent the program from crashing and allow the game to continue running smoothly.
- **Inheritance and polymorphism:** Inheritance will allow different player types, such as human players and AI players, to share attributes and methods from a base `Player` class. Polymorphism will allow different player types to respond differently during their turns.
- **Collections (ArrayList):** ArrayLists will store the players participating in the competition and the words available for the game. They will also make it easier to remove eliminated players and manage the competition.

## How to Compile and Run
1. Click the green **Code** button, choose **Download ZIP**, and unzip it.
2. Open a terminal in the folder that contains the `.java` files.
3. Compile: `javac *.java`
4. Run: `java MainClassName`

## Setup Requirements and Dependencies
- **Java Version:** JDK 17 or later.
- **Additional Files or Libraries:** None. The program uses standard Java libraries and does not require external dependencies.
