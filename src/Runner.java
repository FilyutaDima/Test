
public class Runner {

    public static void main(String[] args){


        double[] mass = {8, 4, 7, 1};
        boolean result = false;

        cicle: for(int a = 0; a <= 3; a++){

            for(int b = 0; b <= 3; b++){

                if(b == a) continue;

                for(int c = 0; c <= 3; c++){

                    if(c == a || c == b) continue;

                    for(int d = 0; d <= 3; d++){

                        if(d == a || d == b || d == c) continue;

                        result = Function.operatorsGeneration(new double[]{mass[a], mass[b], mass[c], mass[d]});
                        if(result) break cicle;
                    }
                }
            }
        }

        if(result){

            System.out.println("Result: " + result);
        }
        else {

            System.out.println("Из данного набора чисел невозможно составить выражение, равное 24");
        }
    }
}
