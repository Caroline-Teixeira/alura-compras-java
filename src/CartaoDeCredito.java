import java.util.ArrayList;
import java.util.List;


public class CartaoDeCredito {


    private double cartaolimite;
    private double saldo;
    private List<Compra> compras;


    //construtor

    public CartaoDeCredito(double cartaolimite) {
        this.cartaolimite = cartaolimite;
        this.saldo = cartaolimite;
        this.compras = new ArrayList<>();
    }


    //gettters e setters

    //Não desejamos deixar nenhuma classe externa alterar o limite, dado que ele foi
    // estabelecido inicialmente, no momento de construção do objeto.
    // Logo, não vamos fazer o setter para o limite e nem para o saldo.


    public double getCartaolimite() {
        return cartaolimite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {

        this.compras = compras;
    }

    //métodos
    public boolean adCompras(Compra compra) {
        if (this.saldo >= compra.getValorDacompra()){
            saldo -= compra.getValorDacompra();
            this.compras.add(compra);
            return true;
        }
        else {
            //System.out.println("Saldo indisponível");
            return false;
        }
    }
}
