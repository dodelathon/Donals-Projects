import javax.swing.*;
import java.util.*;
import java.text.*;
public class imBored
{
	public static void main(String args[])
	{
		boolean end = false, valid = false;
		String decision;
		while(end == false)
		{
			decision = getInput();
			if(decision != null)
			{
				if(decision.equalsIgnoreCase("You Guess"))
				{
					humanGuess();
					valid = false;
					while(valid == false)
					{
						decision = JOptionPane.showInputDialog(null, "Would you like to play again, Enter either of the below to continue?\n1.Yes\n2.No", "Play again",3);
						if(!(decision == null))
						{
							if(decision.equalsIgnoreCase("yes"))
							{
								valid = true;
							}
							else if(decision.equalsIgnoreCase("no"))
							{
								JOptionPane.showMessageDialog(null,"Thanks for playing");
								end = true;
								valid = true;
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Please either enter Yes or No!");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Thanks for playing");
							end = true;
							valid = true;
						}
					}
				}
				else if(decision.equalsIgnoreCase("I Guess"))
				{
					computerGuess();
					valid = false;
					while(valid == false)
					{
						decision = JOptionPane.showInputDialog(null, "Would you like to play again, Enter either of the below to continue?\n1.Yes\n2.No", "Play again",3);
						if(!(decision == null))
						{
							if(decision.equalsIgnoreCase("yes"))
							{
								valid = true;
							}
							else if(decision.equalsIgnoreCase("no"))
							{
								JOptionPane.showMessageDialog(null,"Thanks for playing!");
								end = true;
								valid = true;
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Please either enter Yes or No!");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Thanks for playing!");
							end = true;
							valid = true;
						}
					}						
				}
				else if(decision.equalsIgnoreCase("Stop"))
				{
					JOptionPane.showMessageDialog(null,"Thanks for playing!");
					end = true;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Thanks for playing!");
				end = true;
			}
		}
	}
	
	public static String getInput()
	{
		String mode1 = "I Guess";
		String mode2 = "You Guess";
		String end = "Stop";
		String input = "";
		boolean stop = false;
		while(stop == false)
		{
			input = JOptionPane.showInputDialog(null, "Choose Game mode by entering one of the following phrases:\n1. I Guess - (Computer)\n2. You Guess - (Human)\n3. Stop", "Enter choice", 2);
			if(input == null)
			{
				stop = true;
			}
			else
			{
				input = input.trim();
				if(!(input.equalsIgnoreCase(mode1) || input.equalsIgnoreCase(mode2) || input.equalsIgnoreCase(end)))
				{
					JOptionPane.showMessageDialog(null, "Invalid input, Please enter either:\n'You Guess'\n'I Guess'\n'Stop'");
				}
				else
				{
					stop = true;
				}
			}			
		}
		return input;
	}
	
	public static void computerGuess()
	{
		boolean play = true, valid = false;
		String pattern = "[+]{1}|[-]{1}|[=]{1}";
		String symbol;
		int number = 50, holder = number, Guesses = 0;
		JOptionPane.showMessageDialog(null, "Please choose a number within the range of 0 - 100");
		while(play == true)
		{
			symbol = JOptionPane.showInputDialog(null, "Computer guesses: "+ number +"\nIs the number greater, smaller or equal to your number?\nIndicate your answer with a '+', '-' or '=' Symbol!");
			if(symbol != null)
			{
				symbol = symbol.trim();
				if(!(symbol.matches(pattern)))
				{
					JOptionPane.showMessageDialog(null,"Please enter only the '+', '-' or '=' Symbol!");
				}
				else
				{
					if(symbol.equals("+"))
					{
						if(number < 100)
						{
							Guesses++;
							if(holder > 1)
							{
								holder = holder/2;
								number = number + holder;
							}
							else
							{
								holder = 1;
								number = number + holder;
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Either you Picked a number above 100 or you lied to me in a step");
							play = false;
						}	
					}
					else if(symbol.equals("-"))
					{
						if(number > 0)
						{
							Guesses++;
							if(holder > 1)
							{
								holder = holder/2;
								number = number - holder;
							}
							else
							{
								holder = 1;
								number = number - holder;
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Either you Picked a number below 0 or you lied to me in a step");
							play = false;
						}
					}
					else if(symbol.equals("="))
					{
						JOptionPane.showMessageDialog(null,"Yay I guessed it!\nThe number you had was: " + number + "\nAnd it only took me " + Guesses + " Guesses!");
						play = false;
					}
				}
			}
			else
			{
				play = false;
			}
		}
	}
	
	public static void humanGuess()
	{
		boolean play = true;
		String tempGuess, numPattern = "[0-9]{1,3}";
		int guess, answer, guesses = 0;
		answer = (int)(Math.random() * 100);
		while(play == true)
		{
			tempGuess = JOptionPane.showInputDialog(null, "Enter your guess (1-100)\n(Numbers only)", "Enter guess", 1);
			if(!(tempGuess == null))
			{	
				tempGuess = tempGuess.trim();
				if(tempGuess.matches(numPattern))
				{
					guesses++;
					guess = Integer.parseInt(tempGuess);
					if(!(guess > 100 || guess < 0))
					{
						if(guess > answer)
						{
							JOptionPane.showMessageDialog(null,"Number is less than Guess!");
						}
						else if(guess < answer)
						{
							JOptionPane.showMessageDialog(null,"Number is greater than Guess!");
						}
						else if(guess == answer)
						{
							JOptionPane.showMessageDialog(null,"Yay you guessed it!\nThe number you had was: " + answer + "\nAnd it only took you " + guesses + " Guesses!");
							play = false;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter a number in the range of 1-100!");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please only enter numeric characters!");
				}
			}
			else 
			{
				play = false;
			}
		}
	}
}
		