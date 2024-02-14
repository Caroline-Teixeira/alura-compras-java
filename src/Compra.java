public class Compra implements Comparable<Compra>{

    private String comprasDescricao;
    private double valorDacompra;

    //construtor

    public Compra(String comprasDescricao, double valorDacompra) {
        this.comprasDescricao = comprasDescricao;
        this.valorDacompra = valorDacompra;
    }


    //gettters e setters


    public String getComprasDescricao() {
        return comprasDescricao;
    }

    public double getValorDacompra() {

        return valorDacompra;
    }


    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.valorDacompra).compareTo(Double.valueOf(outraCompra.valorDacompra));
    }

    @Override
    public String toString() {
        return  "Compra: descricao =" + comprasDescricao + " valor = " + valorDacompra;

    }
}


