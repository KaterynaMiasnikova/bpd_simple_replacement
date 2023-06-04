### Simple encryption/decryption methods. Methods of simple replacement

1. Polybian square

The encryption algorithm has the following steps.

- Step 1. Get the encryption key as a Polybian square with random alphabet symbols.

- Step 2. For each symbol of the plaintext, find the symbol of the ciphertext according to the rule: find the symbol of the plaintext and select as the symbol of the ciphertext the one located below it in the same column; if the text symbol is in the bottom row of the table, then for the ciphertext take the uppermost letter from the same column.

The decryption algorithm includes the following steps.

- Step 1. Get the encryption key as a Polybian square with random alphabet symbols.

- Step 2. For each symbol of the ciphertext, the symbol of the plaintext is found according to the rule: find the symbol of the ciphertext and select as the symbol of the plaintext the one that is located above it in the same column, if the symbol of the text is in the top row of the table, then for the ciphertext take the lowest letter from the same column.

2. Caesar's encryption system

When encrypting the source text, each letter was replaced by another letter of the same alphabet according to the following rule: the replacement letter was determined by shifting the initial letter by K letters in the alphabet. Having reached the end of the alphabet, a cyclical transition to its beginning was performed. Caesar used a substitution cipher with an offset of K = 3. Such a substitution cipher can be specified by a table of substitutions containing the corresponding pairs of plaintext and ciphertext letters.

3. Caesar's system with a keyword

It is a monoalphabetic substitution system. A feature of this system (this method) is the use of a keyword to shift and change the order of symbols in the substitution alphabet.
Let's consider this method using the example of the English alphabet.
Let's choose some number K: 0 < K <25, and as a keyword - a word or a short phrase, for example, DIPLOMAT.
NB! It is desirable that all letters of the keyword are different. If there is a repetition in the keyword, then it should be excluded.
Let the chosen number K = 5. Then the Caesar method consists in the fact that the keyword is written under the letters of the alphabet, starting with the letter whose numerical code coincides with the selected number K. The remaining letters of the substitution alphabet are written after the keyword in alphabetical order with the transfer of the last characters alphabet at the beginning of the term. Then we will get a substitution for each letter of an arbitrary message.

4. Encrypting tables of Trisemus

In 1508, the German abbot Johann Trisemus wrote a printed work on cryptology called "Polygraphy". In this book, he first systematically described the use of encryption tables filled with the alphabet in random order. To obtain such a replacement cipher, a table for writing letters of the alphabet and a keyword (or phrase) was usually used.

The encryption algorithm consists of the following steps.

- Step 1. Enter the key word in the table in a size sufficient to accommodate all the letters of the alphabet, while rejecting repeated letters.

- Step 2. Complete the table with letters of the alphabet that were not included before.

- Step 3. As in the case of the Polybian square, find the next letter of the plaintext in the table and write the letter below it in the same column in the ciphertext. If the letter of the text appears in the bottom row of the table, then the uppermost letter from the same column is taken for the ciphertext.

Since the keyword or phrase is easily stored in memory, this approach simplified the encryption and decryption processes.

As in the case of the Polybian square, during encryption, the next letter of the plaintext is found in this table and the letter below it in the same column is written into the ciphertext. If the letter of the text appears in the bottom row of the table, then the uppermost letter from the same column is taken for the ciphertext.