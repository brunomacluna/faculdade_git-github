package condicao;

public class ElseIf {
    // Método para verificar a nota
    public String verificarNota(int nota) {
        if (nota >= 90) {
            return "Nota A";
        } else if (nota >= 80) {
            return "Nota B";
        } else if (nota >= 70) {
            return "Nota C";
        } else if (nota >= 60) {
            return "Nota D";
        } else {
            return "Reprovado";
        }
    } // fim do método verificarNota
    
    // Método para realizar operações matemáticas
    public double calcular(double num1, double num2, char operador) {
        double resultado = -99999; // Valor padrão em caso de erro
        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Não se pode dividir por zero.");
                }
                break;
            case '%':
                resultado = num1 % num2;
                break;
            default:
                System.out.println("Operador inválido");
        } // fim do switch
        return resultado;
    } // fim do método calcular
    
    // Método para calcular a potência
    public int potencia(int n1, int expoente) {
        int resultPotencia = (int) Math.pow(n1, expoente);
        return resultPotencia;
    } // fim do método potencia
    
    // Método para interpretar o semáforo
    public String semaforo(String sinal) {
        String sinaleiro = "";
        switch (sinal.toLowerCase()) { // Usando toLowerCase para evitar problemas com maiúsculas/minúsculas
            case "verde":
                sinaleiro = "Siga em frente";
                break;
            case "amarelo":
                sinaleiro = "Atenção";
                break;
            case "vermelho":
                sinaleiro = "Pare";
                break;
            default:
                sinaleiro = "Sinal inválido";
        } // fim do switch
        return sinaleiro;
    } // fim do método semaforo
} // fim da classe ElseIf
