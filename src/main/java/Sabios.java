import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 23/09/2018
 * Time: 00:28
 * To change this template use File | Settings | File and Code Templates.
 */
public class Sabios {
    Integer qtdSabios;

    public Sabios(Integer qtdSabios) {
        this.qtdSabios = qtdSabios;
    }

    public Integer getQtdSabios() {
        return qtdSabios;
    }

    public void setQtdSabios(Integer qtdSabios) {
        this.qtdSabios = qtdSabios;
    }

    public List<Integer> abencoa(List<Integer> data){
        for (int i = 0; i < getQtdSabios(); i++){
            Collections.sort(data);
            data.set(0, data.get(0) + 1);
        }

        return data;

    }
}
