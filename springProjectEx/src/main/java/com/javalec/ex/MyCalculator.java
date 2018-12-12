package com.javalec.ex;

public class MyCalculator {

	private Calculator calculator;
	private int firstNum;
	private int secondNum;

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public int getFirstNum() {
		return firstNum;
	}
	
	public int getSecondNum() {
		return secondNum;
	}
	
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
	
	public void sub() {
		calculator.substraction(firstNum, secondNum);
	}
	
	public void multi() {
		calculator.multiplication(firstNum, secondNum);
	}
	
	public void div() {
		calculator.division(firstNum, secondNum);
	}

}
