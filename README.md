# Wordle (Java Terminal Edition)

Welcome to **Wordle in Java** — a fast, addictive, color-coded word guessing game right in your terminal.  
You’ve got six attempts to uncover a secret five-letter word. Every letter you type could bring you closer to victory or leave you second-guessing your logic.  
Can you find the word before your chances run out?

---

## How to Play

The rules are simple, but the challenge is hard.

1. The game randomly chooses a **5-letter word** from a word list (`words.txt`).
2. You have **six attempts** to guess it.
3. After each guess, you’ll get feedback on how close you are:

| Color | Meaning |
|:------|:---------|
| Green | Correct letter, right position |
| Yellow | Correct letter, wrong position |
| Red | Letter not in the word |

Your mission: figure out the secret word before you run out of turns.

Example gameplay:
Enter guess #1: CRANE
Feedback: Red, Yellow, Green, Red, Red

Enter guess #2: CRIME
Feedback: Green, Green, Green, Green, Green
Congratulations! You cracked the code!


Copy code

---

## Game Features

- Randomly selects a new word every game from `words.txt`
- Six chances to find the hidden word
- Smart input validation (must be exactly 5 letters, no numbers)
- Color-coded feedback that updates instantly
- Clean, terminal-based interface — no graphics, just pure logic and fun

---

## Project Structure

WordleGame/
├── Wordle.java # Main game file
├── words.txt # List of possible words
└── README.md # This documentation


Copy code

Sample `words.txt`:
brick
flame
crane
crime
piano
ghost


Copy code

---

## How to Run

### Run in VS Code
1. Open the folder containing your files in VS Code.
2. Open the terminal (`Ctrl + \``).
3. Compile and run:
   '
   javac Wordle.java
   java Wordle
Run in a Regular Terminal
Navigate to the project folder:


Copy code
cd path/to/WordleGame
Compile and start the game:


Copy code
javac Wordle.java
java Wordle
Example Session
mathematica
Copy code
Welcome to Wordle!
Try to guess the 5-letter word.

Enter guess #1: PLANT
Feedback: Red, Yellow, Green, Red, Red

Enter guess #2: CRIME
Feedback: Green, Green, Green, Green, Green
You nailed it! Well played.
