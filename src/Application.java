public class Application {
    public static void main(String[] args) {
        Human tom = new Human();
        //tom.walk();
        walker(tom);

        Robot wale = new Robot();
        wale.walk();
        walker(wale);

        //create anonymous class
        walker(new Walkable() {
            @Override
            public void walk() {
                System.out.println("Custom object walking..");
            }
        });

        //lambdaPractical
        walker( () -> System.out.println("Custom object walking using lambdaPractical .."));

        //multiple steps in lambdaPractical
        walker( () -> {
            System.out.println("I am walking.");
            System.out.println("I want to walk as well!");
        });

        //lambdaPractical expression using functional interface
        lambdaInterface var = () -> {
            System.out.println("I am walking.");
            System.out.println("I want to walk as well!");
        };

        //PRACTICE converting methods into lambdaPractical expression
        Walkable helloVar = () -> System.out.println("Hello!");
        helloVar.walk();

        Calculate varSum = (arg1, arg2) ->  arg1 + arg2;
        System.out.println(varSum.compute(5,9));

        Calculate divide = (a, b) -> a/b;
        System.out.println(divide.compute(0,7));

       Reverse revVar = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0 ; i--) {
                result = result + str.charAt(i);
            }
            return result;
        };
        System.out.println(revVar.reverseMethod("Liudmyla"));

        Factorial checkFactorial = (f) -> {
            int result = 1;
            for (int i = 1; i <=f ; i++) {
                result = i*result;
            }
            return result;
        };
        System.out.println(checkFactorial.compute(12));

        // second option using Generic interface
        myGenericInterface <String> reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0 ; i--) {
                result = result + str.charAt(i);
            }
            return result;
        };
        System.out.println(reverse.work("Lambda in Java"));

    }

    public static void walker(Walkable walkableEntity){
        walkableEntity.walk();
    }

    public  void  sayHello(){
        System.out.println("Hello!");
    }

    public int sum(int arg1, int arg2){
        return arg1 + arg2;
    }

    public int nonZeroDivide(int a, int b){
        if(a ==0){
            return 0;
        }
        return a/b;
    }

    public String reverse(String str){
        String result = "";
        for (int i = str.length() - 1; i >= 0 ; i--) {
            result = result + str.charAt(i);
        }
        return result;
    }

    public int factorial(int num){
        int result = 1;
        for (int i = 1; i <=num ; i++) {
            result = i*result;
        }
        return result;
    }
}

interface Calculate{
    public int compute(int a, int b);
}

interface Reverse {
    public String reverseMethod(String str);
}
interface Factorial{
    public int compute(int a);
}

//use Generic interface
interface myGenericInterface<T>{
    public T work(T t);
}