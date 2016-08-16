package tr.org.lyk2016.todo;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String input = "";
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Menu.printMenu();
			input = scanner.nextLine();

			processInput(input);
		}

	}

	private static int processInput(String input) {

		String[] inputParams = input.split(",");

		int action  ;
		try {
			action = Integer.parseInt(inputParams[0]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("**********HATALI GİRİŞ ! TEKRAR DENEYİNİZ...******** ");
			return 0;
		}
		String param = null;
		if (inputParams.length > 1) {
			param = inputParams[1];
		}

		System.out.println("[debug] action: " + action);
		System.out.println("[debug] param: " + param);

		int index;
		switch (action) {
		case 0:
			System.out.println("Exiting...");
			System.exit(0);
		case 1:
			Todo newTodo = new Todo(param);
			TodoHelper.add(newTodo);
			break;
		case 2:
			try {
				index = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TodoHelper.mark(index - 1, true);
			break;
		case 3:
			index = Integer.parseInt(param);
			TodoHelper.remove(index - 1);
			// TODO use TodoHelper's remove method here
			// hint: it's already implemented, you need to just call it (use it)
			// here
			break;
		case 4:
			index = Integer.parseInt(param);
			TodoHelper.mark(index - 1, false);

		default:
			break;
		}
		return 1;

	}
}