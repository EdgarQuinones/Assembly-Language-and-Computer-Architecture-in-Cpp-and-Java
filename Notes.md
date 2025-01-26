# 1.1 Introduction 
- Learn computer concepts by using a simplified one  ^a54b8d
- This chapter talks about number systems (decimal, hex, binary)
## 1.2 Positional Number Systems 
- Decimal, hex, and binary are positional number systems 
$$25.4$$
$$2*10 + 5*1 + 4*(1/10)$$

## 1.3 Arithmetic with positional numbers
- Carry is needed when doing adding or subtracting in any number system
## 1.4 Number Base Conversions 
- Can convert any base into another base
- Some take multip0le conversions 
## 1.5 Horner's Method
- An efficient way to convert hex to decimal 
- multiply, add, multiply, add, repeat...
## 1.6 Signed binary numbers
### 1.6.1 Sign-Magnitude Representation
- Signed numbers mean numbers can be negative, by using the 1st bit as a flag, 1 being negative, 0 being positive.
- **unsigned** means only positive numbers, but **doubling the amount of numbers you can have**
### 1.6.2 Two's Complement Representation
- Flip the bits, and add 1 to check if they are even or odd
- **Standard for computers handling negative numbers**
### One's Complement
- flip the bits, but must handle the carry out 
- Too complex for computers, so not used often
### 1.6.4 Excess-n Representation
- n is added to the value of a number to get its representation
- excess-4 number 6 is `6 - 4 = 2`
## 1.7 Subtraction by two's complement addition
- rather than using the **carry method** used in [[#1.3 Arithmetic with positional numbers]], we can use the **two's complement technique** that *adds the two's complement of B* to A. Since Two's complement of B is equal to -B
## 1.8 Range of two's complement and unsigned numbers
- Range of two's complement is -2^15 to 2^15 -1 because **1 bit is used for signs**
- Unsigned: 0 to 2^n -1
- Signed: -2^n-1 to 2^n-1 -1
## 1.9 Extending two's complement and unsigned numbers
 - If number is positive, add **0s**, if negative, add **1s**
```cpp
// Section 1.9

// Page 18

// Figure 1.6

  

#include <iostream>

using namespace std;

int main()

{

    char c;

    c = -1;

    if (c == -1) // May not result in true based on compiler

        cout << "equal\n";

    else

        cout << "not equal\n";

    return 0;

}
```
## 1.10 Overflow
- Computations are stored in areas of **fixed sizes**
- If the computation is greater than the size, we called this a **overflow**
- Can occur with **unsigned or signed** numbers
### 1.10.1 Signed Overflow
- Can only occur if both numbers are **the same sign (- or +)**
- Overflow of a positive number results in a negative number and vice versa
### 1.10.2 Unsigned Overflow
- If addition results in bigger number, it goes back to smallest number
- If negative, goes to the biggest number
## 1.11 Analyzing two's complement numbers
 - Can flip bits in an n-bit by subtracting by all 1s
## 1.12 Adder circuit 
### 1.12.1 half adder; [Source](https://www.youtube.com/watch?v=5XbRIVWFRIw)
- adds 2 bits, and gives **sum** and **carry**
- Cannot do **multiple additions** if there is a carry involved
- Contains 
	- Input A
	- Input B
	- S (sum)
	- C (Carry)

| A   | B   | Sum | Carry |
| --- | --- | --- | ----- |
| 0   | 0   | 0   | 0     |
| 0   | 1   | 1   | 0     |
| 1   | 0   | 1   | 0     |
| 1   | 1   | 0   | 1     |
- S = A'B + AB' = A XOR B
- C = AB
### 1.12.2 full adder
- Similar to half adder except can add incoming carry bits
- Contains 
	- Input
		- Input A
		- Input B
		- Carry in 
	- Output
		- Sum
		- Carry

| A   | B   | Cin | Sum | Cout |
| --- | --- | --- | --- | ---- |
| 0   | 0   | 0   | 0   | 0    |
| 0   | 0   | 1   | 1   | 0    |
| 0   | 1   | 0   | 1   | 0    |
| 0   | 1   | 1   | 0   | 1    |
| 1   | 0   | 0   | 1   | 0    |
| 1   | 0   | 1   | 0   | 1    |
| 1   | 1   | 0   | 0   | 1    |
| 1   | 1   | 1   | 1   | 1    |
## 1.13 Gates
- NOR - Returns 1 if both are 0
- XOR - returns 1 if both bits are different 
## 1.14 Subtracting using adder
- Since the 2 complements of n is equal to -n, we can simply use addition with the adder even though its technically subtraction
- Only issue is determining the two's complement **takes time**
- It works though by combining XOR and adders
## 1.15 Comparing Signed Numbers
- Computers can compare 2 signed numbers by subtracting them and then applying S and V to an XOR gate, an output of 1 means the result is negative
## 1.16 Comparing unsigned numbers
- Carry flag is used to determine is one is bigger than the other
## 1.17 Uniform treatment of positive, negative, and unsigned numbers
- two's complement add/subtracts **the exact same way** no matter if a number is signed, unsigned, negative, or positive
## 1.18 Floating-Point Representation
- Greater range than two's complement, but lower accuracy
### 1.18.1 Scientific Notation 
- Floats numbers are similar to scientific notation
### 1.18.2 32-Bit IEE 754 Floating-point Format
- Standard for support floating-point numbers
- Contains **3 parts** in binary with the example $1.11011 * 2^3$
	1. 0, the sign of the number (0 for +, 1 for -)
	2. $10000010$, the exponent 3 as an excess-127 8-bit number
	3. $1101100000000000000000$, the 23-bit fractional part of the significand
### 1.18.3 Underflow, Overflow, and Special Values
- All 0s and all 1s are special values, so only the middle values are counted (-126 to 127)
- If a number above or below is given, you will get an *exception* 
### 1.18.4 Computation Error in Some Java Programs
```java
class E1 {

    public static void main(String[] args) {

        float sum = 0.0f, z = 0.001f;

        for (int i = 1; i <= 1000; i++)

            sum = sum + z;

        System.out.println("sum = "+sum); // You would think it would equal 1, but it does not!

  

    }

  

}


class E2 {

    public static void main(String[] args) {

        float sum = 0.0f, z = 1.0f/1024.0f;

        for (int i = 1; i <= 1024; i++)

            sum = sum + z;

        System.out.println("sum = "+sum); // The reason E2 works is because 1.0/1024.0 is a value that can be **exactly represented as a floating point number**

  

    }

  

}
```
- The reason E2 works is because 1.0/1024.0 is a value that can be **exactly represented as a floating point number**

> [!NOTE] Rule 1
> Not all numbers can be represented exactly as floating-point numbers
---

> [!NOTE] Rule 2
> Errors can accumulate

```java
class E3 {

    public static void main(String[] args) {

        float x = 0.0f;

        while (x != 1.0f) // Results in infinite loop

            x += 0.1f;

        System.out.println("x: "+x);

  

    }

  

}

class E4 {

    public static void main(String[] args) {

        float x = 0.0f;

        while (Math.abs(x - 1.0f) > 0.00001f) // Must be close but not equal to 1

            x += 0.1f;

        System.out.println("x: "+x);

  

    }

  

}

```

> [!NOTE] Rule 3
> It is dangerous to test for equality of floating-point numbers

```java
class E5{

    public static void main(String[] args) {

        float L, S;

        L = 1.0f; // L is a Large numebr

        S = 1E-30f; // S is a Small number

        if (L + S == L) //returns equal

            System.out.println("Equal");

        else

            System.out.println("Unequal");

  

    }

  

}
```

> [!NOTE] Rule 4
> If the magnitude of the floating-point number L is sufficiently larger than the magnitude of the floating-point number S, then L + S = L

- Because of **Rule 4**, performing simple operations like addition may not result in what you think:
	- (A + B) + C is **may not be equal to...**
	- A + (B + C)

> [!NOTE] Rule 5
> Flotant-point addition is not associative
```java
class E6 {

    public static void main(String[] args) {

        float sum = 0.0f;

        for (int i = 1; i <= 100; i++)

            sum += 1.0f / i;

        System.out.println("sum: "+sum);

        //sum: 5.187378

        // sum: 5.187377 when starting with 100

  
  
  

    }

  

}

class E7 {

    public static void main(String[] args) {

        float sum = 0.0f;

        for (int i = 100; i >= 1; i--)

            sum += 1.0f / i;

        System.out.println("sum: "+sum);

    }

  

}
```
- Even when trying to divide in both directions, both give **meaningless, and different answers**

> [!NOTE] Rule 6
> Subtracting nearly equal values can produce meaningless results
### 1.18.5 Longer Formats
- Float is *single precision*, while double is *double precision*. The difference comes down to space, but it tends to be worth it if accuracy is what you want
## 1.19 Summary
- **Flags**
	- C - Carry
	- V - Overflow
	- S - Sign
	- Z - Zero
- In addition or subtraction, `V = 1` signals an **overflow has occurred**
- Subtraction of signed numbers
	- `S XOR V = 1`  indicates `top < buttom`
	- `S XOR V = 0` indicates `top >= buttom`
	- `Z = 0` Indicates numbers are unequal
- C functions as a **borrow flag** in subtraction 
- In addition/subtraction of **unsigned numbers**
	- `C = 1` signals **overflow has occurred**
	- Subtraction `C = 1` means `top < buttom`
		- `C = 0` means `top >= bottom`
		- `Z = 1` means equal else unequal
- Z is set to 1 if result is zero, and 0 if result is non-zero
- Floating points can be precise, but not perfect