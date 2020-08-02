# CoffeeMachineDesign
A Java code to simulate a coffee vending machine.

# Code flow
The entry point is the Main.java file and all inputs are hardcoded for now due to lack of time. The constructors can be easily extended to accept dynamic inputs. The `tst/` folder can be used to test different types of inputs without having to change the code. I have added some samples there.
# Design patterns used
I have used decorator pattern to extend this to any variant of a beverage that can be introduced and Observer pattern for store keeping. However, since there is only ione observer at the moment, I have kept it as a pull based model.
