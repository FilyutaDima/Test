import java.util.ArrayDeque;
import java.util.Stack;

public class Function {

    public static boolean operatorsGeneration(double[] mass){

        char[] operators = {'+', '-', '*', '/'};
        boolean result = false;

        cicle: for(int a = 0; a <= 3; a++){

            for(int b = 0; b <= 3; b++){

                for(int c = 0; c <= 3; c++){

                    result = positionsGeneration(mass, new char[]{operators[a], operators[b], operators[c]});
                    if(result) break cicle;
                }
            }
        }
        return result;
    }

    private static boolean positionsGeneration(double[] mass, char[] operators){

        boolean result = false;

        int[][] positions = {
                                {2, 2, 4},
                                {2, 3, 4},
                                {2, 4, 5},
                                {3, 3, 4},
                                {3, 4, 5},
                                {4, 5, 6},
                            };

        for(int i = 0; i < positions.length; i++){

            result = func(mass, operators, positions[i]);
        }

        return result;
    }

    private static boolean func(double[] mass, char[] operators, int[] positions){

        int index = 0;
        boolean result = false;

        ArrayDeque<Double> deque = new ArrayDeque<>();
        Stack<Character> sOperators = new Stack<>();

        for(int i = 0; i <= 6; i++){

            if(deque.size() > 1){

                if(index < positions.length && i == positions[index]){

                    double b = deque.pollLast();
                    double a = deque.pollLast();

                    deque.addLast(count(a, b, operators[index]));
                    index++;

                    if(index < positions.length && i == positions[index]){

                            b = deque.pollLast();
                            a = deque.pollLast();

                            deque.addLast(count(a, b, operators[index]));
                            index++;

                    }
                }
            }
            else {

                sOperators.push(operators[index]);
                index++;
            }


            if(i < mass.length){

                deque.addLast(mass[i]);
            }

            if(i == 6){

                if(!sOperators.isEmpty()){

                    while(deque.size() > 1){

                        double b = deque.pollLast();
                        double a = deque.pollLast();

                        deque.addLast(count(a, b, sOperators.pop()));
                    }
                }

                if(deque.peekLast() == 24){

                    result = true;
                    System.out.println(mass[0] + " " + mass[1] + " " + mass[2] + " " + mass[3]);
                    System.out.println(positions[0] + " " + positions[1] + " " + positions[2]);
                    System.out.println(operators[0] + " " + operators[1] + " " + operators[2]);
                    System.out.println(deque.pollLast());
                    System.out.println("*************");
                } else{

                    index = 0;
                    deque.poll();
                }
            }
        }
        return result;
    }

    private static double count(double a, double b, char operator){

        double result = 0;

        switch (operator){

            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }

        return result;
    }
}
