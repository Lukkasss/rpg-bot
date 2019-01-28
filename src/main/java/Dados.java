/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 23/09/2018
 * Time: 00:29
 * To change this template use File | Settings | File and Code Templates.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dados {
    private Integer qtdDados;
    private ArrayList<Integer> resultado = new ArrayList<Integer>();

    public Dados(Integer qtdDados) {
        this.qtdDados = qtdDados;
    }

    public void rolar(){
        Random gerar = new Random();

        for (int i = 0; i < qtdDados; i++)
            resultado.add(gerar.nextInt(10) + 1);


    }

    public Integer getQtdDados() {
        return qtdDados;
    }

    public void setQtdDados(Integer qtdDados) {
        this.qtdDados = qtdDados;
    }

    public ArrayList<Integer> getResultado() {
        return resultado;
    }

    public void transforma(){
        for (int i = 0; i < resultado.size(); i++)
            switch(resultado.get(i)){

                case 1:
                    resultado.set(i, -3);
                case 2:
                    resultado.set(i, -2);
                    break;
                case 3:
                    resultado.set(i, -1);
                    break;
                case 4:
                    resultado.set(i, 0);
                    break;
                case 5:
                    resultado.set(i, 1);
                    break;
                case 6:
                    resultado.set(i, 2);
                    break;
                case 7:
                    resultado.set(i, 3);
                    break;
                case 8:
                    resultado.set(i, 4);
                    break;
                case 9:
                    resultado.set(i, 5);
                    break;
                case 10:
                    Dados confirmar2 = new Dados(1);
                    confirmar2.rolar();
                    resultado.set(i, 6 + confirmar2.getResultado().get(0));
            }
    }

    public void ordenar(){
        Collections.sort(getResultado());
    }

    public int somar(ArrayList<Integer> data){
        int soma = 0;
        for (int i = 0; i < data.size(); i++)
            soma += data.get(i);
        return soma;
    }
}
