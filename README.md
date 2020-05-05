# Requirements
- Java 11
- Maven

# How to run the tests in the project
Run the command
`$ mvn clean test`

# Assumptions
The following assumptions have been made for the input and output of the methods.

- Only english characters will be classified as "words". 
- The methods ignore numbers and any other characters/punctuation, if there is any form of punctuation
 or invalid character between words it will be split i.e. "hello,thâere" would be split "hello", "th" "ere"
- The one rule excluded for this would be apostrophe i.e. "we're" would be classified as one word of length 5
- If there are multiple words of the same length, return all the words.
- Word uniqueness is case-sensitive.
- If there are 2 of the same word, only return the unique word.
- If no word greatest or smallest, size will be zero and no words provided

