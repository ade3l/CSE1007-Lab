# Acitivity-3 Inheritance and Exception Handling
You are expected to develop activity using the following concepts in Java Object Oriented Programming,

-   Classes and Objects
-   Constructor and its Types
-   Inheritance
-   this and super keywords
-   Exception Handling  
    

**Activity Description:**

> The aim of this activity is to develop a calculator using Java OOP
> concept. Create an interface _CalculatorFunctions_ which defines all
> calculator operations required for developing a calculator. Assume
> that the calculator will accept maximum of two values and one operator
> (E.g. _x+y, x-y, x*y, x^2, x^y, e^x,_ ...). Create an abstract class
> _BasicCalculator_ which can override some of the basic methods from _CalculatorFunctions_ interface. Create a child class _ScientificCalculator_ and inherit from _BasicCalculator_ and override the remaining methods from the interface. Create your own exception
> class for validating input values and operators (E.g.
> NotValidNumberException and NotValidOperator) and handle the exception
> properly.

**Root Level**

*Interface*->*CalculatorFunctions*  

Abstract Class -> Calculator *implements*  CalculatorFunctions

*Inheritance  (Do not implement interface in child class instead access through abstract class)*

_BasicCalculator -> ScientificCalculator_
